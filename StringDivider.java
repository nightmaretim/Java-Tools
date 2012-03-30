//StringDivider.java

package editool.tool;

import java.util.Vector;


/**
	<p>
		�^����ꂽ�������^����ꂽ�����ŕ������A������̔z��ɂ��ĕԂ��N���X�ł��B
	</p>
**/
public class StringDivider
{

	//�����Ώۂ̕�����
	private String db_string;
	//������̊i�[�x�N�g��
	private Vector<String> r_vector;
	//�f���~�^���g�p����Ƃ��Ɋi�[����ϐ�
	private char delimiter;
	//�������ŕ������鎞�̐��l���i�[����ϐ�
	private int d_num[];

	/**
		<p>
			�������R���X�g���N�^�B
		</p>
	**/
	public StringDivider()
	{
		db_string="";
		r_vector = new Vector<String>();
		delimiter = '|';
		d_num=null;
	}

	/**
		<p>
			�f���~�^��p�����������s���ۂ̃R���X�g���N�^�B
			������ƃf���~�^�������󂯎��B

			@param st �������镶����
			@param d �f���~�^�ƂȂ镶��
		</p>
	**/
	public StringDivider(String st , char d)
	{
		this();

		//������i�[
		db_string = st;
		//�f���~�^�����i�[
		delimiter = d;

	}

	/**
		<p>
			�f���~�^��p�����������s���ۂ̃R���X�g���N�^�B
			������ƃf���~�^�������󂯎��B

			@param st �������镶����
			@param num ��������ۂɎg�p���镶�������i�[����int�z��
		</p>
	 **/
	public StringDivider(String st , int num[])
	{
		this();

		//������i�[
		db_string = st;
		//����������̔z��i�[
		d_num = num;

	}

	/**
		<p>
			�f���~�^��p�����������s�����\�b�h�B
			��������������𕶎���z��Ɋi�[����
			return����B

			@return ��������������̔z��
		</p>
	**/
	public String[] delimiterDivider()
	{
		//�ꎞ�ۊǗp������ϐ�
		String temp = "";

		for (int i = 0 ; i < db_string.length() ; i++)
		{
			if(db_string.charAt(i) == delimiter)
			{
				//�x�N�g���Ɋi�[
				r_vector.add(temp);
				//temp������
				temp = "";

			}
			else
			{
				temp = temp + db_string.charAt(i);
			}

		}

		//���[�v�I����Atemp�ɕ���������΁A
		//�x�N�g���ɒǉ�����
		if (temp.equals("")==false)
		{
			//�x�N�g���ɒǉ�
			r_vector.add(temp);
			temp="";
		}

		//return������z��
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
		}

		return r_string;
	}

	/**
	<p>
		�f���~�^��p�����������s�����\�b�h�B
		��������������𕶎���z��Ɋi�[����
		return����B
		�A���Aparam�Ŏ󂯎����char�ň͂܂ꂽ�������������ꍇ�A
		���̊Ԃł̕����͍s��Ȃ��悤�ɂ���B

		@param char �ی삷�镶����̑O��ɒu�����char
		@return ��������������̔z��
	</p>
**/
public String[] delimiterDividerWith(char c)
{
	//�ꎞ�ۊǗp������ϐ�
	String temp = "";
	boolean flag = false;

	for (int i = 0 ; i < db_string.length() ; i++)
	{
		if(db_string.charAt(i) == delimiter && !flag)
		{
			//�x�N�g���Ɋi�[
			r_vector.add(temp);
			//temp������
			temp = "";

		}
		else
		{
			temp = temp + db_string.charAt(i);

			if(db_string.charAt(i) == c)
			{
				if(flag)
				{
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
		}

	}

	//���[�v�I����Atemp�ɕ���������΁A
	//�x�N�g���ɒǉ�����
	if (temp.equals("")==false)
	{
		//�x�N�g���ɒǉ�
		r_vector.add(temp);
		temp="";
	}

	//return������z��
	String r_string[] = new String[r_vector.size()];
	for(int i = 0 ; i < r_vector.size() ; i++)
	{
		r_string[i] = (String)r_vector.elementAt(i);
	}

	return r_string;
}

	/**
		<p>
			�����������������ꂽ�z���p�����������s�����\�b�h�B
			��������������𕶎���z��Ɋi�[����
			return����B

			�t�ы@�\�Ƃ��āA�X�y�[�X����������

			@return ��������������̔z��
		</p>
	 **/
	public String[] numArrangementDividerSpaceTrim()
	{
		//�ꎞ�ۊǗp������ϐ�
		String temp = "";

		int a = 0;
		int b = 0;

		for (int i = 0 ; i < db_string.length() ; i++)
		{



			if(a == d_num[b])
			{
				//�x�N�g���Ɋi�[
				r_vector.add(temp);
				//temp������
				temp = "";
				a=0;
				b++;
				if(d_num.length < b)
				{
					break;
				}
				i--;

			}
			else
			{
				temp = temp + db_string.charAt(i);
				a++;
			}

		}

		//���[�v�I����Atemp�ɕ���������΁A
		//�x�N�g���ɒǉ�����
		if (temp.equals("")==false)
		{
			//�x�N�g���ɒǉ�
			r_vector.add(temp);
			temp="";
		}

		//return������z��
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
			r_string[i] = StaticStringProcesser.characterDeleter(r_string[i], ' ');
		}

		return r_string;
	}

	/**
		<p>
			�����������������ꂽ�z���p�����������s�����\�b�h�B
			��������������𕶎���z��Ɋi�[����
			return����B

			@return ��������������̔z��
		</p>
	 **/
	public String[] numArrangementDivider()
	{
		//�ꎞ�ۊǗp������ϐ�
		String temp = "";

		int a = 0;
		int b = 0;

		for (int i = 0 ; i < db_string.length() ; i++)
		{



			if(a == d_num[b])
			{
				//�x�N�g���Ɋi�[
				r_vector.add(temp);
				//temp������
				temp = "";
				a=0;
				b++;
				if(d_num.length < b)
				{
					break;
				}
				i--;

			}
			else
			{
				temp = temp + db_string.charAt(i);
				a++;
			}

		}

		//���[�v�I����Atemp�ɕ���������΁A
		//�x�N�g���ɒǉ�����
		if (temp.equals("")==false)
		{
			//�x�N�g���ɒǉ�
			r_vector.add(temp);
			temp="";
		}

		//return������z��
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
		}

		return r_string;
	}

	/**
		<p>
			�����������������ꂽ�z���p�����������s�����\�b�h�B
			��������������𕶎���z��Ɋi�[����
			return����B
			�o�C�g�z���p���邽�߁A���p�A�S�p�𐳊m�ɕ�������B

			@return ��������������̔z��
		</p>
	 **/
	public String[] numArrangementDividerByte()
	{
		//�����񕪊��̂��߂�temp
		int a = 0;
		//�o�C�g�z��
		byte by[] = db_string.getBytes();

		for (int i = 0 ; i < d_num.length ; i++)
		{

			byte bytemp[] = new byte[d_num[i]];

			for (int j = 0 ; j < d_num[i] ; j++)
			{
				bytemp[j] = by[a + j];
			}
			//�x�N�g���Ɋi�[
			r_vector.add(new String(bytemp));
			//���X�^�[�g����ۊ�
			a = a + d_num[i];

		}

		//return������z��
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
		}

		return r_string;
	}

	/**
		<p>
			�����������������ꂽ�z���p�����������s�����\�b�h�B
			��������������𕶎���z��Ɋi�[����
			return����B
			�o�C�g�z���p���邽�߁A���p�A�S�p�𐳊m�ɕ�������B

			�t���@�\�Ƃ��āA�X�y�[�X���폜����B

			@return ��������������̔z��
		</p>
	 **/
	public String[] numArrangementDividerByteSpaceTrim()
	{
		//�����񕪊��̂��߂�temp
		int a = 0;
		//�o�C�g�z��
		byte by[] = db_string.getBytes();

		for (int i = 0 ; i < d_num.length ; i++)
		{

			byte bytemp[] = new byte[d_num[i]];

			for (int j = 0 ; j < d_num[i] ; j++)
			{
				bytemp[j] = by[a + j];
			}
			//�x�N�g���Ɋi�[
			r_vector.add(new String(bytemp));
			//���X�^�[�g����ۊ�
			a = a + d_num[i];

		}

		//return������z��
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
			r_string[i] = StaticStringProcesser.characterDeleter(r_string[i], ' ');
		}

		return r_string;
	}

	/**
		<p>
			�����������������ꂽ�z���p�����������s���O�ɁA
			�^����ꂽ������̒����ƁA�^����ꂽ�����p�����z���
			���v���̊֌W����A�����̐��ۂ𔻒f���郁�\�b�h
			�^����ꂽ������̒���>=�^����ꂽ�����p�����z��̍��v�@true
			                      <                                 false

			@return Boolean ����
		</p>
	**/
	public boolean checkNumArrangementDivider()
	{
		int num = 0;
		for(int n : d_num)
			num += n;

		if(db_string.length() >= num)
			return true;
		else
			return false;
	}

	/**
		<p>
			�����������������ꂽ�z���p�����������s���O�ɁA
			�^����ꂽ������(�o�C�g)�̒����ƁA�^����ꂽ�����p�����z���
			���v���̊֌W����A�����̐��ۂ𔻒f���郁�\�b�h
			�^����ꂽ������̒���>=�^����ꂽ�����p�����z��̍��v�@true
			                      <                                 false

			@return Boolean ����
		</p>
	**/
	public boolean checkNumArrangementDividerByte()
	{
		int num = 0;
		for(int n : d_num)
			num += n;

		if(db_string.getBytes().length >= num)
			return true;
		else
			return false;
	}
}
