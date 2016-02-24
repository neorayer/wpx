
#drop database db_log;
CREATE DATABASE db_log CHARACTER SET utf8 COLLATE utf8_general_ci;
use db_log;
CREATE TABLE tb_login_log (uuid varchar(64),time  varchar(64),account  varchar(64),domain  varchar(64),ip  varchar(64),type  varchar(64));
CREATE TABLE tb_mail_log (uuid varchar(64),sendTime  varchar(64),mailType varchar(64),mailFrom varchar(64),rcptTo varchar(64),size varchar(64),result varchar(255),cause varchar(255),remark varchar(64));

#drop database db_wpx2;

CREATE DATABASE db_wpx2 CHARACTER SET utf8 COLLATE utf8_general_ci;
use db_wpx2;
#alter table tb_account drop tail;
#alter table tb_account drop head;
#alter table tb_department drop tail;
#alter table tb_department drop head;
#alter table tb_domain add column ishidepubaddress  varchar(255);
#alter table tb_department add column sortNum bigint;
#alter table tb_account add column sortNum bigint;
#update tb_account set tb_account.maxcc = 10000 where tb_account.uid = 'postmaster';


#alter table tb_account add column groupSend bigint;
create table tb_groupuser (uuid varchar(255),uid varchar(255),dc varchar(255),mails longtext);

CREATE TABLE tb_modfunc (funcid  varchar(255),funcname  varchar(255),status bigint);
CREATE TABLE tb_smtpTrushIp (ip  varchar(255),createtime  varchar(255),description  varchar(255));
CREATE TABLE tb_singleconf (keyname  varchar(255),value  varchar(255));

create table tb_addrAdmin (uid varchar(255),userPassword varchar(255),status varchar(255),dc varchar(255),ou varchar(255),deptname varchar(255));
CREATE TABLE tb_manager_log (time  varchar(255),role  varchar(255),account  varchar(255),domain  varchar(255),ip  varchar(255),opdetail  varchar(255),optype  varchar(255));
CREATE TABLE tb_ipsegment (fromip  varchar(255) ,type bigint ,uuid  varchar(255) ,dc  varchar(255) ,toip  varchar(255) ,primary key(uuid));
#alter table tb_ipsegment add column dc varchar(255);

CREATE TABLE tb_account (idcard varchar(255),groupSend bigint,sortNum bigint,createdate  varchar(255),birthday  varchar(255),ishide bigint,c  varchar(255),cn  varchar(255),co  varchar(255),company  varchar(255),employeeid  varchar(255),employeenumber  varchar(255),facsimiletelephonenumber  varchar(255),givenname  varchar(255),homephone  varchar(255),indexset  varchar(255),initials  varchar(255),isproxy  varchar(255),l  varchar(255),mail  varchar(255),mobile  varchar(255),msn  varchar(255),o  varchar(255),oicq  varchar(255),otheremail  varchar(255),ou  varchar(255),pager  varchar(255),pausecause  varchar(255),pausetime  varchar(255),pc  varchar(255),pfax  varchar(255),phone  varchar(255),physicaldeliveryofficename  varchar(255),pl  varchar(255),postaladdress  varchar(255),postalcode  varchar(255),ppa  varchar(255),ppc  varchar(255),pst  varchar(255),pwdanswer  varchar(255),pwdquestion  varchar(255),rdn  varchar(255),remark  varchar(255),sex  varchar(255),sn  varchar(255),st  varchar(255),telephonenumber  varchar(255),uuid  varchar(255),web  varchar(255),webfunction  varchar(255),spell  varchar(255),url  varchar(255),title  varchar(255),description  varchar(255),displayname  varchar(255),uid  varchar(255),userpassword  varchar(255),dc  varchar(255),sendername  varchar(255),autoreplycontent  varchar(255),mnpp bigint,savenew  varchar(255),maxcc bigint,forward bigint,forwardaddr  varchar(255),autoreplyswitch  varchar(255),spacealert bigint,messagesize bigint,issmtp  varchar(255),rejectdomain  longtext,rejectemail  longtext,rejectesubject  longtext,storagelocation  varchar(255),replymail  varchar(255),ispop3  varchar(255),addrbookfilter bigint,size bigint,status  varchar(255));
CREATE TABLE tb_domain (dc  varchar(255),ishidepubaddress  varchar(255),attachmentsize bigint,alias  varchar(255),applytype  varchar(255),defaultboxsize bigint,sizelocate bigint,template  varchar(255),userlocate bigint,usermax bigint,strangerfilter bigint,size bigint,description  varchar(255));
CREATE TABLE tb_domainAlias (dc  varchar(255),aliasedobjectname  varchar(255));
CREATE TABLE tb_superAdmin (dc  varchar(255),uid  varchar(255),userpassword  varchar(255),status  varchar(255));
CREATE TABLE tb_multiDomainAdmin (dc  varchar(255),sizelocate  varchar(255),roomnumber  varchar(255),size  varchar(255),description  varchar(255),uid  varchar(255),userpassword  varchar(255),status  varchar(255));
CREATE TABLE tb_domainAdmin (dc  varchar(255),uid  varchar(255),userpassword  varchar(255),status  varchar(255));
CREATE TABLE tb_department (ou  varchar(255),domain  varchar(255),sortNum bigint,parentuuid  varchar(255),description  varchar(255),uuid  varchar(255));
CREATE TABLE tb_userAlias (uid  varchar(255),dc  varchar(255),aliasedobjectname  varchar(255));
CREATE TABLE tb_notice (content  varchar(255),sender  varchar(255),subject  varchar(255),state bigint,date  varchar(255),owner  varchar(255),type  varchar(255),uuid  varchar(255));
CREATE TABLE tb_ipFilterChange (changetype bigint,uuid  varchar(255));
CREATE TABLE tb_ipFilterItem (changetype bigint,ip  varchar(255));
CREATE TABLE tb_addressbook_group (spell  varchar(255),symbol  varchar(255),groupname  varchar(255),parentuuid  varchar(255),description  varchar(255),owner  varchar(255),uuid  varchar(255));
CREATE TABLE tb_addressbook_person (birthday  varchar(255),c  varchar(255),cn  varchar(255),co  varchar(255),company  varchar(255),employeeid  varchar(255),givenname  varchar(255),homephone  varchar(255),initials  varchar(255),l  varchar(255),mail  varchar(255),mobile  varchar(255),msn  varchar(255),o  varchar(255),oicq  varchar(255),ou  varchar(255),pager  varchar(255),pc  varchar(255),pfax  varchar(255),phone  varchar(255),physicaldeliveryofficename  varchar(255),pl  varchar(255),postaladdress  varchar(255),postalcode  varchar(255),ppa  varchar(255),ppc  varchar(255),pst  varchar(255),rdn  varchar(255),remark  varchar(255),sex  varchar(255),sn  varchar(255),st  varchar(255),web  varchar(255),spell  varchar(255),comego  varchar(255),facsimiletelephonenumber  varchar(255),groupid  varchar(255),telephonenumber  varchar(255),url  varchar(255),title  varchar(255),rank bigint,owner  varchar(255),displayname  varchar(255),uuid  varchar(255));
CREATE TABLE tb_addressbook_AddrConf (id  varchar(255),lockedsource bigint);
CREATE TABLE tb_bookmark_Folder (parentuuid  varchar(255),publictag  varchar(255),name  varchar(255),description  varchar(255),owner  varchar(255),uuid  varchar(255),primary key(uuid));
CREATE TABLE tb_bookmark_Item (url  varchar(255),folderuuid  varchar(255),name  varchar(255),description  varchar(255),owner  varchar(255),uuid  varchar(255),primary key(uuid));
CREATE TABLE tb_mail_ink (ink longtext,name  varchar(255),owner  varchar(255),uuid  varchar(255));
CREATE TABLE tb_rninfo (password  varchar(255),serinum  varchar(255),identitycard  varchar(255),realname  varchar(255),datetime  varchar(255),operator  varchar(255),tel  varchar(255),address  varchar(255));
CREATE TABLE tb_rnmanager (role bigint,password  varchar(255),username  varchar(255),realname  varchar(255),uuid  varchar(255));
CREATE TABLE tb_serinum (password  varchar(255),serinum  varchar(255),createdate  varchar(255),status bigint);
CREATE TABLE tb_article (content longtext,columnuuid  varchar(255),createtime  varchar(255),publishtime  varchar(255),summary  varchar(255),title  varchar(255),uuid  varchar(255));
CREATE TABLE tb_attachment (originalfilename  varchar(255),filesize  varchar(255),articleuuid  varchar(255),filesuffix  varchar(255),isimage bool,name  varchar(255),uuid  varchar(255));
CREATE TABLE tb_column (engid  varchar(255),parentuuid  varchar(255),name  varchar(255),uuid  varchar(255));
CREATE TABLE tb_todaycover (imagename  varchar(255),relativearticleuuid  varchar(255),title  varchar(255),date  varchar(255),type  varchar(255),uuid  varchar(255));
CREATE TABLE tb_note (content  varchar(255),category  varchar(255),date  varchar(255),owner  varchar(255),uuid  varchar(255));
CREATE TABLE tb_timerMail (ou  varchar(255),domain  varchar(255),mailpath  varchar(255),mailuuid  varchar(255),time  varchar(255),state  varchar(255),title  varchar(255),type  varchar(255),uuid  varchar(255));
CREATE TABLE tb_shareFile (domain  varchar(255),username  varchar(255),folderpath  varchar(255),shareid  varchar(255),begintime bigint,sharedays bigint,shareto  varchar(255),location  varchar(255),filename  varchar(255),uuid  varchar(255));
CREATE TABLE tb_album_Folder (parentuuid  varchar(255),coverpictureuuid  varchar(255),createdate  varchar(255),accesscount bigint,publictag  varchar(255),originalpath  varchar(255),thumbpath  varchar(255),updatedate  varchar(255),name  varchar(255),description  varchar(255),owner  varchar(255),uuid  varchar(255));
CREATE TABLE tb_album_Picture (folderuuid  varchar(255),curangle bigint,aperture  varchar(255),datetimedigitized  varchar(255),focallength  varchar(255),iso  varchar(255),maker  varchar(255),shutterspeed  varchar(255),ext  varchar(255),bytesize bigint,cataloguuid  varchar(255),model  varchar(255),height bigint,width bigint,createdate  varchar(255),accesscount bigint,publictag  varchar(255),originalpath  varchar(255),thumbpath  varchar(255),updatedate  varchar(255),name  varchar(255),description  varchar(255),owner  varchar(255),uuid  varchar(255));
CREATE TABLE tb_album_ElementShare (publicelementid  varchar(255),publicelementtype  varchar(255),publicusers  varchar(255),token  varchar(255),uuid  varchar(255));
CREATE TABLE tb_album_AlbumCatalog (createdate  varchar(255),updatedate  varchar(255),name  varchar(255),description  varchar(255),uuid  varchar(255));
CREATE TABLE tb_album_RecommendFolder (folderuuid  varchar(255),cataloguuid  varchar(255),uuid  varchar(255));
CREATE TABLE tb_album_RecommendPicture (cataloguuid  varchar(255),pictureuuid  varchar(255),uuid  varchar(255));
CREATE TABLE tb_album_Comment (createdate  varchar(255),content  varchar(255),updatedate  varchar(255),albumelementuuid  varchar(255),author  varchar(255),uuid  varchar(255));
CREATE TABLE tb_domainAdminOU (ou  varchar(255),dc  varchar(255));
CREATE TABLE tb_addressbookAdminOU (ou  varchar(255),dc  varchar(255));
CREATE TABLE tb_adminOU (dc  varchar(255));
CREATE TABLE tb_multiDomainAdminOU (ou  varchar(255),dc  varchar(255));
INSERT INTO tb_superAdmin(dc,uid,userpassword,status) VALUES ('','admin','111111','');


CREATE TABLE tb_regdata (realname  varchar(255),idcard  varchar(255));
CREATE TABLE tb_regdatabak (realname  varchar(255),idcard  varchar(255));
CREATE TABLE tb_blogClassify (name  varchar(255),owner  varchar(255));
CREATE TABLE tb_blogArticle (isexpose bool,parentowner  varchar(255),covertalk  varchar(255),isdraft bool,artype bigint,issuggested bool,isselfsuggest bool,readcount bigint,upcount bigint,downcount bigint,parentuuid  varchar(255),content longtext,createddate varchar(255),createddatetime  varchar(255),updatedat  varchar(255),owner  varchar(255),title  varchar(255),level bigint,uuid varchar(255));
CREATE TABLE tb_blogClassifyArticle (isdraft bool,createddate  varchar(255),createddatetime  varchar(255),owner  varchar(255),articletitle  varchar(255),classifyname  varchar(255),articleuuid  varchar(255));
CREATE TABLE com_skymiracle_wpx_blog_BlogReadLog (reader  varchar(255),ip  varchar(255),owner  varchar(255),articleuuid  varchar(255),readdate  varchar(255),readdatetime  varchar(255),type bigint,uuid  varchar(255));
CREATE TABLE com_skymiracle_wpx_blog_BlogTopRecord (count bigint,owner  varchar(255),articleuuid  varchar(255),sortperiod bigint,type bigint,uuid  varchar(255));
CREATE TABLE tb_blogUpDownLog (articleuuid  varchar(255),operator  varchar(255),updowntag bigint);
CREATE TABLE tb_userBlogInfo (styleid varchar(255), blognickname varchar(255),owner  varchar(255),readcount bigint,createddate  varchar(255),createddatetime  varchar(255),updatedat  varchar(255),blogtitle  varchar(255),style  varchar(255));
CREATE TABLE tb_blogstyle (stylename  varchar(255) ,styletype  varchar(255) ,createddatetime  varchar(255) ,uuid  varchar(255) ,primary key(uuid));
#alter table tb_userBlogInfo add column blognickname varchar(255);
#alter table tb_blogArticle add column isexpose bool;
#alter table tb_userBlogInfo add column styleid varchar(255);

create table tb_information (uuid varchar(255),typeId varchar(255),subject varchar(255),content longtext,summary varchar(255),star bigint,isHref bigint,publishDate varchar(255),createDate varchar(255),publishTime varchar(255),createTime varchar(255));
create table tb_information_type (uuid varchar(255),parentUuid varchar(255),engid varchar(255),name varchar(255),status bigint,memo varchar(255),filePath varchar(255));
create table tb_information_subscription (uuid varchar(255),username varchar(255),appTime varchar(255),typeId varchar(255),status bigint,isHref bigint);
#alter table tb_information_type add column filePath  varchar(255);
#alter table tb_account add column idcard  varchar(255);
#alter table tb_account add column skin varchar(4);

CREATE TABLE tb_ebill_userBill (owner  varchar(255),dianfei  varchar(255),dianxin  varchar(255),gongjijin  varchar(255),liantong  varchar(255),ranqifei  varchar(255),shuifei  varchar(255),shuzidianshi  varchar(255),yanglaojin  varchar(255),yibao  varchar(255),yidong  varchar(255),other1  varchar(255),other2  varchar(255),other3  varchar(255),uuid  varchar(255));
CREATE TABLE tb_ebill_yibao (num  varchar(255),idcard  varchar(255),scrq  varchar(255),xm  varchar(255),iccard  varchar(255),jfys  varchar(255),qjys  varchar(255),zhje  varchar(255),ys  varchar(255),ss  varchar(255),qs  varchar(255),cxfm  varchar(255),batch  varchar(255),uuid  varchar(255));
CREATE TABLE tb_ebill_yangLaoJin (num  varchar(255),idcard  varchar(255),scrq  varchar(255),cxfm  varchar(255),yjfjs  varchar(255),grzhgr  varchar(255),grzhdw  varchar(255),grzhsp  varchar(255),jnys  varchar(255),qfjegr  varchar(255),qfjedw  varchar(255),batch  varchar(255),uuid  varchar(255));
CREATE TABLE tb_ebillAdmin (role  varchar(255),createdate  varchar(255),status  varchar(255),uid  varchar(255),userpassword  varchar(255),dc  varchar(255));
CREATE TABLE tb_billBatch (updatetime  varchar(255),billname  varchar(255),batchid  varchar(255),billclassname  varchar(255),status bigint);
CREATE TABLE tb_ebilladmin_type (name  varchar(255),engid  varchar(255),memo  varchar(255),status  varchar(255));
CREATE TABLE tb_ebill_shuiFei (jfzk  varchar(255),idcard  varchar(255),xm  varchar(255),address  varchar(255),yhlb  varchar(255),sycbs  varchar(255),bycbs  varchar(255),sjsys  varchar(255),sfdj  varchar(255),psfdj  varchar(255),sf  varchar(255),psf  varchar(255),zje  varchar(255),cxfm  varchar(255),batch  varchar(255),uuid  varchar(255));
CREATE TABLE tb_ebill_gongjijin (idcard  varchar(255),xm  varchar(255),dwdm  varchar(255),grdm  varchar(255),gz  varchar(255),gryjje  varchar(255),dwyjje  varchar(255),czyje  varchar(255),status  varchar(255),zhye  varchar(255),jzny  varchar(255),cxms  varchar(255),batch  varchar(255),uuid  varchar(255));
CREATE TABLE tb_ebill_ranQiFei (idcard  varchar(255),xm  varchar(255),address  varchar(255),cxfm  varchar(255),bz  varchar(255),cbygh  varchar(255),ymds  varchar(255),qmyc  varchar(255),qmqf  varchar(255),rjrq  varchar(255),ycyc  varchar(255),ycqf  varchar(255),ycds  varchar(255),znj  varchar(255),jfje  varchar(255),byyl  varchar(255),dj  varchar(255),fwf  varchar(255),mqf  varchar(255),jzrq  varchar(255),batch  varchar(255),uuid  varchar(255));
CREATE TABLE tb_ebill_jiaotongfadan (idcard  varchar(255),hpzl  varchar(255),lxdh  varchar(255),djzsbh  varchar(255),cxfm  varchar(255),batch  varchar(255),uuid  varchar(255));

create index IDX_uid_dc on tb_account (uid(64), dc(64));
create index IDX_dc_uid on tb_account (dc(64), uid(64));

#alter table tb_account add column ebill  varchar(255);


CREATE TABLE tb_regkey (username  varchar(255) ,checkcode  varchar(255) ,regtime  varchar(255) ,primary key(username));
CREATE TABLE tb_inforAdmin (role  varchar(255),createdate  varchar(255),status  varchar(255),uid  varchar(255),userpassword  varchar(255),dc  varchar(255));


#new
alter table tb_addressbook_group add column count int;
alter table tb_department add column count int;
alter table tb_domain add column savenew varchar(64);
alter table tb_ipsegment add column useType varchar(64);
alter table tb_ipsegment add column dc varchar(64);

CREATE TABLE tb_fax (id  varchar(64),mail  varchar(64),primary key(id));

alter table tb_bookmark_Folder add primary key(uuid);
alter table tb_bookmark_Item add primary key(uuid);


CREATE TABLE tb_send_mail_stat (time  varchar(64) ,mail  varchar(64) ,count bigint ,stattype  varchar(255) ,isperfect int ,primary key(time,mail));
