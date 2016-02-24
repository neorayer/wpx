var WpxTool = {
	byteToM : function(b) {
		b = new Number(b);
		return (b / 1024 / 1024).toFixed(0);
	},

	mToByte : function(m) {
		m = new Number(m);
		return m * 1024 * 1024;
	}
}