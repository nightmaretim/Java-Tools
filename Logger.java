package editool.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
	<p>
		���O���L�^����N���X�ł��B�t�B�[���h�Ƃ��ă��O�t�@�C���o�͗p�̃N���X��
		�Ώۃf�B���N�g����t�@�C��������File�I�u�W�F�N�g�������܂��B
		�e�탁�\�b�h���g�p���Ďg�p�����𐮂��A���O���L�^���܂��B
	</p>
**/
public class Logger
{
	//���O�t�@�C���p�o�̓N���X
	private FileOutputStream fos_log;
	private OutputStreamWriter osw_log;
	private BufferedWriter bw_log;

	//�Ώۃf�B���N�g���ƑΏۃt�@�C���p
	private InDirectoryFile idf;
	private File logfile;

	private final String EXTENSION = ".log";

	public Logger()
	{
		//���O�t�@�C���p�o�̓N���X
		fos_log = null;
		osw_log = null;
		bw_log = null;

		//�Ώۃf�B���N�g���ƑΏۃt�@�C��
		idf =new InDirectoryFile();
		logfile = null;
	}

	/**
		<p>
			�Ώۃf�B���N�g�����t�@�C���Ƃ��Đ������邩�������܂��B
			�o���Ȃ����IOException��f���o���܂��B

			@throws IOException
		</p>
	 **/
	public boolean setBaseDir(String basedir) throws IOException
	{
		idf = new InDirectoryFile(basedir);

		return idf.targetInvestigation();
	}

	/**
		<p>
			�Ώۃf�B���N�g���Ƀ��O�t�@�C�����쐬���܂��B
			���O�t�@�C�����͈�����filename�{���݂̓��t����.log�ł��B
			�o���Ȃ����IOException��f���o���܂��B

			@throws IOException
		</p>
	 **/
	public boolean setLogFile(String filename) throws IOException
	{
		if(!idf.targetInvestigation())
		{
			return false;
		}

		String time = TimeTool.getNowTime();
		logfile = idf.setFile(filename+time+EXTENSION);

		fos_log = new FileOutputStream(logfile);
		osw_log = new OutputStreamWriter(fos_log);
		bw_log = new BufferedWriter(osw_log);

		return true;
	}

	/**
		<p>
			�Ώۃf�B���N�g���̈�ԌÂ����O���폜���܂��B
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
	public int oldestLogDeleter(int lognum) throws IOException
	{
		int count = 0;

		if(!idf.targetInvestigation())
		{
			return -1;
		}

		count = idf.oldestFileNameDeleter(lognum);

		return count;
	}

	/**
		<p>
			�t�@�C���Ƀ��O���������݂܂��B
			��������t�т��ď������݂܂��B

			@param String �������݂���������
			@return int �폜�����t�@�C����

			@throws IOException
		</p>
	 **/
	public void writeLog(String logstr) throws IOException
	{
		if(bw_log!=null)
		{
			bw_log.write(TimeTool.getNowTime() + logstr);
			bw_log.newLine();
		}
	}

	/**
	<p>
		logger���N���[�Y���܂��B
		setLogFile�����s�������Ƃ͕K�����̃��\�b�h��
		BufferdWriter���N���[�Y���܂��B

		@param int �c�������t�@�C����
		@return int �폜�����t�@�C����

		@throws IOException
	</p>
 **/
	public void close() throws IOException
	{
		//bw_log���C�^�[�̃N���[�Y
		try
		{
			if (bw_log != null)
			{
				bw_log.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
