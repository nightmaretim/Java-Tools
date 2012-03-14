package editool.tool;

import java.util.Calendar;

/**
	<p>
		���t�A�����ɑ΂��Ă悭�g�����\�b�h���W�߂�Static�N���X�ł��B
	</p>
	**/
public class TimeTool
{

	private static final int YEAR_LENGTH_LONG = 4;
	private static final int YEAR_LENGTH_SHORT = 2;

	/**
		<p>
			���݂̓��t�A�����𕶎���ɂ��ĕԂ��܂��B
			yyyymmddhhmmss�ł��B

			@return String �������̕�����

		</p>
	 **/
	public static String getNowTime()
	{
		Calendar cal = Calendar.getInstance();
		String time = TimeTool.getTimePlusZero(cal.get(Calendar.YEAR)) + TimeTool.getTimePlusZero((cal.get(Calendar.MONTH)+1)) +TimeTool.getTimePlusZero(cal.get(Calendar.DATE))+TimeTool.getTimePlusZero(cal.get(Calendar.HOUR_OF_DAY)) + TimeTool.getTimePlusZero(cal.get(Calendar.MINUTE))+TimeTool.getTimePlusZero(cal.get(Calendar.SECOND));
		return time;
	}

	/**
		<p>
			���A���t�A���ԁA���A�b�Ȃǂ̂��߂ɁA1��01�ƕ�����ϊ����邽�߂̃N���X�ł��B
			10�ȉ��̏ꍇ��0��t���ĕ����񉻂��܂��B
			@param int 0������Ώې��l
			@return String 0������������
		</p>
	 **/
	public static String getTimePlusZero(int num)
	{
		if(num < 10)
		{
			return "0" + Integer.toString(num);
		}

		return Integer.toString(num);
	}

	/**
		<p>
			���t������yymmdd��yyyymmdd�̕�����ŕԂ��܂��B
			@param String yymmdd�`���̓��t������
			@return String yyyymmdd�`���̕�����
		</p>
	 **/
	public static String yymmddParseYyyymmdd(String yymmdd)
	{
		int num[] = {2,2,2};

		StringDivider sd = new StringDivider(yymmdd , num);

		String str[] = sd.numArrangementDivider();

		String return_string = "";

		for(int i = 0; i < str.length ; i++)
		{
			if (i == 0)
			{
				if (str[0].length() == YEAR_LENGTH_SHORT)
				{
					return_string =  new Integer(nowYearYy()).toString() + str[i];

				}
				else
				{
					return_string = str[i];
				}
			}
			else
			{
				return_string = return_string + TimeTool.getTimePlusZero(Integer.parseInt(str[i]));
			}
		}

		return return_string;

}


	/**
		<p>
			/�ŋ�؂�̓��t������yy/mm/dd��yyyymmdd�̕�����ŕԂ��܂��B
			@param String /��؂�̓��t������
			@return String yyyymmdd�`���̕�����
		</p>
	 **/
	public static String delSlashYymmddParseYyyymmdd(String slashstring)
	{
		StringDivider sd = new StringDivider(slashstring , '/');

		String str[] = sd.delimiterDivider();

		String return_string = "";

		for(int i = 0; i < str.length ; i++)
		{
			if (i == 0)
			{
				if (str[0].length() == YEAR_LENGTH_SHORT)
				{
					return_string =  new Integer(nowYearYy()).toString() + str[i];

				}
				else
				{
					return_string = str[i];
				}
			}
			else
			{
				return_string = return_string + TimeTool.getTimePlusZero(Integer.parseInt(str[i]));
			}
		}

		return return_string;

	}

	/**
		<p>
			/�ŋ�؂�̓��t������yy-mm-dd��yyyymmdd�̕�����ŕԂ��܂��B
			@param String -��؂�̓��t������
			@return String yyyymmdd�`���̕�����
		</p>
	 **/
	public static String delHifunYymmddParseYyyymmdd(String hifunstring)
	{
		StringDivider sd = new StringDivider(hifunstring , '-');

		String str[] = sd.delimiterDivider();

		String return_string = "";

		for(int i = 0; i < str.length ; i++)
		{
			if (i == 0)
			{
				if (str[0].length() == YEAR_LENGTH_SHORT)
				{
					return_string =  new Integer(nowYearYy()).toString() + str[i];

				}
				else
				{
					return_string = str[i];
				}
			}
			else
			{
				return_string = return_string + TimeTool.getTimePlusZero(Integer.parseInt(str[i]));
			}
		}

		return return_string;

	}

	/**
		<p>
			/�ŋ�؂�̓��t������yyyy/mm/dd��yyyymmdd�̕�����ŕԂ��܂��B
			@param String /��؂�̓��t������yyyy/mm/dd
			@return String yyyymmdd�`���̕�����
		</p>
	**/
	public static String delSlashYyyymmddParseYyyymmdd(String slashstring)
	{
	StringDivider sd = new StringDivider(slashstring , '/');

	String str[] = sd.delimiterDivider();

	String return_string = "";

	for(int i = 0; i < str.length ; i++)
	{

		return_string = return_string + TimeTool.getTimePlusZero(Integer.parseInt(str[i]));

	}

	return return_string;

	}

	/**
		<p>
			�N������؂�̓��t������yyyy�Nmm��dd����yyyymmdd�̕�����ŕԂ��܂��B
			@param String �N������؂�̓��t������
			@return String yyyymmdd�`���̕�����
		</p>
	 **/
	public static String delNengappiParseYyyymmdd(String string)
	{
		string = StaticStringProcesser.characterDeleter(string, '�N');
		string = StaticStringProcesser.characterDeleter(string, '��');
		string = StaticStringProcesser.characterDeleter(string, '��');

		return string;

	}

	/**
		<p>
			�����œn���ꂽyyyymm�`���̔N����\����int��
			�����ЂƂ�int�����ŔN���̃��[���ɑ����Čv�Z���܂��B

			@param int �v�Z�Ώۂ̔N��int yyyymm�`��
			@param int �������ސ��� ���������ꍇ��-��
			@return int �v�Z����yyyymmdd�`����int
		</p>
	 **/
	public static int sumIntYyyyMm(int ym , int sum_num)
	{
		final int MONTH = 12;
		final int SUM_MONTH = 100;

		//�N�������̌�������12���傫��������G���[ -1
		if(ym%SUM_MONTH > MONTH)
		{
			return -1;
		}

		//�v�Z�Ώۂ̐�����12�`-12�͈͓̔��łȂ�������G���[
		if(sum_num > 12 || sum_num < -12)
		{
			return -2;
		}

		int temp_year = ym/SUM_MONTH;
		int return_ym = ym + sum_num;

		if(temp_year != return_ym/SUM_MONTH)
		{
			return_ym = return_ym - (SUM_MONTH - MONTH);
		}
		else if(return_ym%SUM_MONTH > MONTH)
		{
			return_ym = return_ym + SUM_MONTH;
			return_ym = return_ym - MONTH;
		}

		return return_ym;
	}

	/**
		<p>
			�N���̓��t������yy/m��yyyymm�̕�����ŕԂ��܂��B
			@param String /��؂�̔N��������
			@return String yyyymm�`���̕�����
		</p>
	 **/
	public static String delSlashParseYyyymm(String yyslashm)
	{
		StringDivider sd = new StringDivider(yyslashm , '/');

		String str[] = sd.delimiterDivider();

		String return_string = "";

		for(int i = 0; i < str.length ; i++)
		{
			if (i == 0)
			{
				return_string = new Integer(nowYearYy()).toString() + str[i];
			}
			else
			{
				return_string = return_string + TimeTool.getTimePlusZero(Integer.parseInt(str[i]));
			}
		}

		return return_string;


	}

	/**
		<p>
			�N���̓��t������yymm��yyyymm�̕�����ŕԂ��܂��B
			@param String yymm�`���̕�����
			@return String yyyymm�`���̕�����
		</p>
	 **/
	public static String parseYymmToYyyymm(String yymm)
	{
		int num[] = {2,2};
		StringDivider sd = new StringDivider(yymm , num);

		String str[] = sd.numArrangementDivider();

		String return_string = "";

		for(int i = 0; i < str.length ; i++)
		{
			if (i == 0)
			{
				return_string = new Integer(nowYearYy()).toString() + str[i];
			}
			else
			{
				return_string = return_string + TimeTool.getTimePlusZero(Integer.parseInt(str[i]));
			}
		}

		return return_string;


	}

	/**
		<p>
			�N�����̓��t������m/d��yyyymmdd�̕�����ŕԂ��܂��B
			yyyymm�`���̔N�����󂯎���āA����Ȃ��ꍇ�͕ۊǂ��܂��B
			@param String /��؂�̔N����������
			@param String yyyymm�`���̔N��
			@return String yyyymmdd�`���̕�����
		</p>
	 **/
	public static String delSlashMsdParseYyyymmdd(String yyslashm, String yyyymm)
	{
		StringDivider sd = new StringDivider(yyslashm , '/');

		String str[] = sd.delimiterDivider();

		String return_string = yyyymm.substring(0, 4);

		for(int i = 0; i < str.length ; i++)
		{
			return_string = return_string + TimeTool.getTimePlusZero(Integer.parseInt(str[i]));
		}

		return return_string;


	}

	/**
		<p>
			�N�����̓��t������d��yyyymmdd�̕�����ŕԂ��܂��B
			yyyymm�`���̔N�����󂯎���āA����Ȃ��ꍇ�͕ۊǂ��܂��B
			@param String /��؂�̔N����������
			@param String yyyymm�`���̔N��
			@return String yyyymmdd�`���̕�����
		</p>
	 **/
	public static String delSlashDParseYyyymmdd(String d , String yyyymm)
	{

		return yyyymm + TimeTool.getTimePlusZero(Integer.parseInt(d));

	}

	/**
		<p>
			���t�����Z�v���O�����ł��B
			yyyymmdd�`���̓��t���󂯎��A��������̕ϐ�d�������Z���A
			yyyymmdd�`���ŕԂ��܂��B
			@param int ymd �v�Z�Ώۂ�8��int���tyyyymmdd
			@param int d �����Z��������@int
			@return int �v�Z����yyyymmdd�`���̕�����
		</p>
	 **/
	public static int dateCalculationIntYyyymmdd(int ymd , int d)
	{
		final int YEAR_NUM = 10000;
		final int MONTH_NUM = 100;

		//ymd����N�������o
		int year = ymd / YEAR_NUM;
		int month = (ymd%YEAR_NUM) / MONTH_NUM;
		int day = ymd % MONTH_NUM;

		//ymd��Calendar�I�u�W�F�N�g�쐬
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, day);

		//d�������Z
		c.add(Calendar.DATE , d);

		//year,mounth,day�ɓW�J
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DATE);

		//yyyymmdd�`���ɂ���return
		return (year * YEAR_NUM) + (month * MONTH_NUM) + day;
	}

	/**
		<p>
			���ݎ�����int�^yyyymmdd�`���ŕԂ��v���O�����ł��B
			@return int yyyymmdd�`���̌�����
		</p>
	 **/
	public static int nowIntYyyymmdd()
	{
		final int YEAR_NUM = 10000;
		final int MONTH_NUM = 100;

		//ymd��Calendar�I�u�W�F�N�g�쐬
		Calendar c = Calendar.getInstance();

		//year,mounth,day�ɓW�J
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);

		//yyyymmdd�`���ɂ���return
		return (year * YEAR_NUM) + (month * MONTH_NUM) + day;
	}

	//���݂̔N�̏�ʂQ�P�^��Ԃ��v���C�x�[�g���\�b�h
	private static int nowYearYy()
	{
		//ymd��Calendar�I�u�W�F�N�g�쐬
		Calendar c = Calendar.getInstance();

		//year,mounth,day�ɓW�J
		int year = c.get(Calendar.YEAR);

		return year/100;
	}
}
