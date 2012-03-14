package editool.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
	<p>
		あるディレクトリに置いてあるファイルに対していろいろ行うクラスです。
	</p>
**/

public class InDirectoryFile
{
	private String directoryname;
	private File targetdir;

	public InDirectoryFile()
	{
		directoryname = null;
		targetdir = null;
	}

	public InDirectoryFile(String dn)
	{
		directoryname = dn;
	}

	/**
		<p>
			対象ディレクトリがファイルとして成立するか調査します。
			出来なければIOExceptionを吐き出します。
			他のメソッドを行う前にかならず実行する。
			@return boolean 成否

			@throws IOException
		</p>
	 **/
	public boolean targetInvestigation() throws IOException
	{

		targetdir = new File(directoryname);

		return true;
	}

	/**
		<p>
			対象ディレクトリのファイル、ディレクトリの一覧をString入れるで返すクラスです。

			@return 対象ディレクトリに存在するファイル、ディレクトリの一覧String配列
			@throws IOException
		</p>
	 **/
	public String[] getFileList() throws IOException
	{

		if(targetdir==null)
		{
			this.targetInvestigation();
		}

		if (targetdir.exists() && targetdir.isDirectory())
		{

			String filenames[] = targetdir.list();
			return filenames;
		}

		return null;
	}

	/**
		<p>
			対象ディレクトリに存在するファイルをファイル名を指定してFileオブジェクトで返すメソッドです。
			@param Strong 対象ファイルのファイル名
			@return File 対象ファイルのFileオブジェクト
			@throws IOException
		</p>
	 **/
	public File setFile(String filename) throws IOException
	{

		if(targetdir==null)
		{
			this.targetInvestigation();
		}

		if (targetdir.exists() && targetdir.isDirectory())
		{

			File file = new File(targetdir + "\\" + filename);

			return file;
		}

		return null;
	}

	/**
		<p>
			対象ディレクトリのファイ名が一番古いファイルを削除します。
			引数で残しておくログ数を渡し、その数より
			対象ディレクトリのファイル数が多かった場合、
			ファイル名で一番若いと判断されたファイルを削除します。
			削除したファイル数を返します。
			何も対象ディレクトリ判断失敗時は-1を返します。

			@param int 残したいファイル数
			@return int 削除したファイル数

			@throws IOException
		</p>
	 **/
	public int oldestFileNameDeleter(int lognum) throws IOException
	{
		int count = 0;

		if(!this.targetInvestigation())
		{
			return -1;
		}

		String filelist[] = this.getFileList();

		List<String> array = new ArrayList<String>();

		for(int i = 0; i < filelist.length;i++)
		{
			array.add(filelist[i]);
		}
		Collections.sort(array);
		if(array.size() > lognum)
		{
			for(int i = array.size() -1;i >= 0;i--)
			{
				if(i < array.size() - lognum)
				{
					File f = this.setFile(array.get(i));
					f.delete();
					count++;
				}
			}
		}

		return count;
	}
}
