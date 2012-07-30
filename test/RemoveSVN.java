import java.io.File;


public class RemoveSVN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file=new File(".");
		removeSvn(file);
		
	}
	
	public static void removeSvn(File file){
		if(file.isDirectory()){
			if(file.getName().equals(".svn")){
				System.out.println("delate:"+file.getAbsolutePath());
				boolean r=file.delete();
				System.out.println(r);
			}
			String files[]=file.list();
			for(int i=0;i<files.length;i++){
				removeSvn(new File(file,files[i]));
			}
		}else{
			//System.out.println("file:"+file.isFile());
		}
	}

}
