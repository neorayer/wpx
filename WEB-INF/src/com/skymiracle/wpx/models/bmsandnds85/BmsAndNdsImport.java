package com.skymiracle.wpx.models.bmsandnds85;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.skymiracle.csv.Csv;
import com.skymiracle.logger.Logger;

public class BmsAndNdsImport {
	public static void exec(File csvFile) throws IOException {
		Csv csv = new Csv(csvFile.getAbsolutePath(), "UTF-8");
		csv.load();

		String[] labels = csv.getLabels();
		int fatherpath_index = -1;
		int filename_index = -1;
		int fmode_index = -1;
		int storagesize_index = -1;
		for (int i = 0; i < labels.length; i++) {
			String label = (labels[i] == null ? null : labels[i].trim());
			if ("fatherpath".equals(label)) {
				fatherpath_index = i;
			} else if ("filename".equalsIgnoreCase(label)) {
				filename_index = i;
			} else if ("fmode".equalsIgnoreCase(label)) {
				fmode_index = i;
			} else if ("storagesize".equalsIgnoreCase(label)) {
				storagesize_index = i;
			}
		}
		if (fatherpath_index == -1) {
			throw new IOException("fatherpath label not find");
		}
		if (filename_index == -1) {
			throw new IOException("filename label not find");
		}
		if (fmode_index == -1) {
			throw new IOException("fmode label not find");
		}
		if (storagesize_index == -1) {
			throw new IOException("storagesize label not find");
		}

		ArrayList<String[]> list = csv.getLineList();

		ArrayList<UserRecord> records = new ArrayList<UserRecord>();
		int i = 1;
		for (String[] line : list) {
			String fatherpath = line[fatherpath_index];
			i++;
			if (fatherpath.endsWith("/func=bookmark")
					|| fatherpath.endsWith("/func=storage")) {
				continue;
			}

			String[] fp = fatherpath.split("/");
			if (fp.length <= 3)
				continue;

			UserRecord ur = null;
			if ("func=storage".equals(fp[3])) {
				ur = new NdRecord(fp[1].replace("vdomain=", ""), fp[2].replace(
						"user=", ""));
			} else if ("func=bookmark".equals(fp[3])) {
				ur = new BmRecord(fp[1].replace("vdomain=", ""), fp[2].replace(
						"user=", ""));
			} else {
				continue;
			}

			String dir = fp[4].replace("dir=", "");
			if (fp.length > 4) {
				for (int j = 5; j < fp.length; j++) {
					dir = dir + "-" + fp[j].replace("dir=", "");
				}
			}
			ur.dir = dir;
			// filename
			ur.name = line[filename_index];
			// fmode
			if ("DIR".equalsIgnoreCase(line[fmode_index])) {
				ur.isdir = true;
			} else {
				// netdisk filepath or bookmark urls
				if (line.length - 1 >= storagesize_index)
					ur.memo = line[storagesize_index];

				// size
				// if (!"LNK".equalsIgnoreCase(line[4])) {
				// try {
				// ur.size = Long.parseLong(line[5]);
				// } catch (Exception e) {
				// }
				// }
			}

			records.add(ur);
		}

		// sort
		Collections.sort(records, new Comparator<UserRecord>() {
			public int compare(UserRecord o1, UserRecord o2) {
				try {
					int r = o1.type.compareTo(o2.type);
					if (r == 0)
						r = new Boolean(o2.isdir).compareTo(new Boolean(
								o1.isdir));

					return r;
				} catch (Exception e) {
					Logger.error("", e);
				}
				return 0;
			}
		});

		for (UserRecord ur : records) {
			System.out.println(ur);
			try {
				ur.create();
			} catch (Exception e) {
				System.out.println("Error: " + ur + "\tReason:"
						+ e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String filepath = "C:/Documents and Settings/tianliang/桌面/asdfasd.csv";
		File file = new File(filepath);

		exec(file);
	}
}
