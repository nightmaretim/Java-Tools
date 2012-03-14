package editool.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
	<p>
		����f�B���N�g���ɒu���Ă���t�@�C���ɑ΂��Ă��낢��s���N���X�ł��B
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
			�Ώۃf�B���N�g�����t�@�C���Ƃ��Đ������邩�������܂��B
			�o���Ȃ����IOException��f���o���܂��B
			���̃��\�b�h���s���O�ɂ��Ȃ炸���s����B
			@return boolean ����

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
			�Ώۃf�B���N�g���̃t�@�C���A�f�B���N�g���̈ꗗ��String�����ŕԂ��N���X�ł��B

			@return �Ώۃf�B���N�g���ɑ��݂���t�@�C���A�f�B���N�g���̈ꗗString�z��
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
			�Ώۃf�B���N�g���ɑ��݂���t�@�C�����t�@�C�������w�肵��File�I�u�W�F�N�g�ŕԂ����\�b�h�ł��B
			@param Strong �Ώۃt�@�C���̃t�@�C����
			@return File �Ώۃt�@�C����File�I�u�W�F�N�g
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
			�Ώۃf�B���N�g���̃t�@�C������ԌÂ��t�@�C�����폜���܂��B
			�����Ŏc���Ă������O����n���A���̐����
			�Ώۃf�B���N�g���̃t�@�C���������������ꍇ�A
			�t�@�C�����ň�ԎႢ�Ɣ��f���ꂽ�t�@�C�����폜���܂��B
			�폜�����t�@�C������Ԃ��܂��B
			�����Ώۃf�B���N�g�����f���s����-1��Ԃ��܂��B

			@param int �c�������t�@�C����
			@return int �폜�����t�@�C����

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
