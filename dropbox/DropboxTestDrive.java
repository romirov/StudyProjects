import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

class DropboxTestDrive{

	public static void main(String[] args){
		String dropboxAccessToken = "_S9RJqcARnEAAAAAAAAAAapkYKVeY2WZ1usm0pT9wphuphxIENfCpTA2dk_HGIxf";
		DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
	        DbxClientV2 client = new DbxClientV2(config, dropboxAccessToken);

		// Upload "test.txt" to Dropbox
		try{ 
			InputStream in = new FileInputStream("/home/hanza/java/dropbox/java.jpg"); 
		    	FileMetadata metadata = client.files().uploadBuilder("/java.jpg").uploadAndFinish(in);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
