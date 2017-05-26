package savePlace;
/**
 * 作业：更改字体颜色
 * 实现修改功能
 * 
 * 五种存储方式
 * SharedPreferences：内存卡存储，是一个接口
 * 		主要用来存储配置信息，适用于保存少量数据，数据格式简单
 * 		举例：LoginActivity，welcomewActivity
 * 		welcomeActivity 中还包含了actionBar菜单，startActivityForRequest
 * File
 * 		两个方法打开本应用程序的数据文件
 * 		FileputStream OpenFileInput(String name)
 * 		FileOutputStream 
 * 		getDir(String name,int mode)//获取或创建目录
 * 		File getFileDir()//获取文件
 * 		String[] filelist();
 * 		deleteFile(String name);
 * 		
 * 		读取SD卡中的文件
 * 		getExternalStorageDirectory() ：获取外部存储根目录
 * 		公有类型目录
 * 		私有
 * SQLite
 * ContentProvider
 * 网络存储
 * 
 * 
 * 课堂作业
 * @author jules
 *
 */
public class SavePlaceInfo {

}
