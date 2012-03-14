package editool.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
	<p>
		�t�@�C�����L�^����N���X�ł��B�t�B�[���h�Ƃ��ăt�@�C���o�͗p�̃N���X��
		�Ώۃf�B���N�g����t�@�C��������File�I�u�W�F�N�g�������܂��B
		�e�탁�\�b�h���g�p���Ďg�p�����𐮂��A���O���L�^���܂��B
	</p>
**/
public class FileKeeper
{
	//�t�@�C���p�o�̓N���X

	//�Ώۃf�B���N�g���ƑΏۃt�@�C���p
	private InDirectoryFile target_idf;
	private final String EXTENSION = ".dat";

	public FileKeeper()
	{
		//�Ώۃf�B���N�g���ƑΏۃt�@�C��
		target_idf = new InDirectoryFile();
	}

	/**
		<p>
			�Ώۃf�B���N�g�����t�@�C���Ƃ��Đ������邩�������܂��B
			�o���Ȃ����IOException��f���o���܂��B

			@throws IOException
		</p>
	 **/
	public boolean setTargetBaseDir(String targetbase) throws IOException
	{
		target_idf = new InDirectoryFile(targetbase);

		return target_idf.targetInvestigation();

	}

	/**
		<p>
			source�t�@�C����target�f�B���N�g����
			���O��ς��ăR�s�[���܂��B

			@param String keep��t�@�C���̊�{��
			@return String �R�s�[���̃t�@�C�������R�s�[��̃t�@�C����
			@throws IOException
		</p>
	 **/
	public String fileKeep(String filename,File sourcefile) throws IOException
	{
		if(!target_idf.targetInvestigation())
		{
			return "nokeep";
		}

		String time = TimeTool.getNowTime();
		File targetfile = target_idf.setFile(filename+time+EXTENSION);

		FileChannel targetchannel = new FileOutputStream(targetfile).getChannel();
		FileChannel sourcechannel = new FileInputStream(sourcefile).getChannel();
		sourcechannel.transferTo(0, sourcechannel.size(), targetchannel);
        sourcechannel.close();
        targetchannel.close();

        return sourcefile.getName() + "�́A"+ targetfile.getName() + "�ɕϊ�����܂����B";
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
	public int oldestFileDeleter(int filenum) throws IOException
	{
		int count = 0;

		if(!target_idf.targetInvestigation())
		{
			return -1;
		}

		count = target_idf.oldestFileNameDeleter(filenum);

		return count;
	}

}
