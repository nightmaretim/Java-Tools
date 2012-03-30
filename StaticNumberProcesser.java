package editool.tool;

/**
	<p>
		�����Ɋւ��Ă��낢�돈�����s��Static�N���X�ł��B
	</p>
**/

public class StaticNumberProcesser
{
	/**
		<p>
			�����񉻂������l��Float.parseFloat���g����float�ɕϊ����郁�\�b�h�B
			�����񂪃u�����N�̏ꍇ�́A0��Ԃ�
			@param String float�����鐔�l������
			@return float float���������l
		</p>
	**/
	public static float parseFloatPlus(String str) throws NumberFormatException
	{
		if(str=="")
		{
			return 0;
		}

		return Float.parseFloat(str);
	}
	/**
		<p>
			�����񉻂������l��Double.parseDouble���g����double�ɕϊ����郁�\�b�h�B
			�����񂪃u�����N�̏ꍇ�́A0��Ԃ�
			@param String double�����鐔�l������
			@return double double���������l
		</p>
	**/
	public static double parseDoublePlus(String str) throws NumberFormatException
	{
		if(str=="")
		{
			return 0;
		}

		return Double.parseDouble(str);
	}
	/**
		<p>
			�����񉻂������l��Integer.parseInt���g����int�ɕϊ����郁�\�b�h�B
			�����񂪃u�����N�̏ꍇ�́A0��Ԃ�
			@param String int�����鐔�l������
			@return int int���������l
		</p>
	**/
	public static int parseIntPlus(String str) throws NumberFormatException
	{
		if(str=="")
		{
			return 0;
		}

		return Integer.parseInt(str);
	}

	/*
	 * ������^�̐������󂯎��A2���ő�����A�܂�P���Ȃ�O��0��⊮����v���O�����ł��B
	 *
	 * @param String 0��t�����镶���� ( 2�����ȉ�)
	 * @return String �Q���ɑ�����������
	 */
	public static String stringNumberXX(String s) throws NumberFormatException
	{
		if(s.length() > 2)
		{
			return null;
		}

		if(s.length() == 1)
		{
			return "0" + s;
		}

		return s;
	}

	/*
	 * ������^�̐����̑O��0���g���~���O����B0�ȊO�̕����������o�����_�ŏI��
	 *
	 * @param String 0���g���~���O���镶����
	 * @return String �g���~���O����������
	 */
	public static String stringNumberZeroTrimer(String s) throws NumberFormatException
	{

		//return�p������
		String s_str = "";
		//�ŏ���0�łȂ������񐔎����o���Ƃ��̃t���O
		boolean flag = false;

		//����������ꕶ�������ׁA0���A�����Ă��Ȃ������ׂ�B
		//�����͕����񒷂�-1�܂Œ��ׂ�B
		for ( int i = 0 ; i < s.length() ; i++)
		{

			if ( s.charAt(i) != '0' || flag)
			{
				s_str = s_str + new Character(s.charAt(i)).toString();
				flag = true;
			}

		}

		return s_str;
	}

	/*
	 * �����̌����𒲂ׂ邽�߂ɁA�����ƌ����������󂯎��A
	 * �10��(����������-1)�Ő���������������Ԃ��܂��B
	 *
	 * ��@�����@70,000 5
	 * 10�̏�@10,000������@7
	 * ��@�����@3,000 5
	 * 10�̂S��@10,000������@0.3�@int�ɑ�����邩��0
	 * ��@�����@400,000 5
	 * 10�̂S��@10,000������@40
	 * 10�ȏゾ�����ꍇ�@�����ӂ�Ƃ���false��Ԃ��܂�
	 *
	 *
	 * @param int �Ώۂ̐���
	 * @param int �����̐���
	 * @return boolean ����
	 */
	public static boolean disitCheck(int target , int disit)
	{
		final int base = 10;
		int temp_int = 0;

		temp_int = (int)(target / Math.pow((double)base, (double)(disit - 1)));

		if (temp_int >= base)
			return false;

		return true;
	}

	/*
	 * �����̌����𒲂ׂ邽�߂ɁA�����ƌ��������i�������A�������j���󂯎��A
	 * ���肵�܂�
	 *
	 * ��@�����@70.22,5,2
	 *   true
	 * ��@�����@805.235,5,2
	 *   false
	 *
	 * @param double �Ώۂ̐���
	 * @param int �����������̐���
	 * @param int �����������̐���
	 * @return boolean ����
	 */
	public static boolean disitCheckDouble(double target , int disit_i , int disit_d)
	{
		//������ �`�F�b�N��disitCheck���\�b�h�𗘗p
		final int base = 10;
		final int decimal_base = 1;
		int temp_int = 0;

		temp_int = (int)target;

		if (!disitCheck(temp_int , disit_i))
			return false;

		//������
		double temp_double = 0;
		temp_double = (target * Math.pow((double)base, (double)disit_d))%decimal_base;

		if(temp_double > 0)
			return false;

		return true;
	}
}
