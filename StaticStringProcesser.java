//StaticStringProcesser.java

package editool.tool;

/**
	<p>
		������ł悭�s�������܂Ƃ߂�static�N���X�ł��B
	</p>
**/

public class StaticStringProcesser
{

	/**
		<p>
			static���\�b�h�����Ȃ̂ŁA�R���X�g���N�^��K�v�Ƃ��܂���B
		</p>
	**/
	public StaticStringProcesser()
	{
	}

	/**
		<p>
			������(String)�ƍ폜����������(char)���󂯎��A�����������폜������������
			��菜��static���\�b�h�ł��B

			@param st �Ώە�����(String)
			@param c �폜����������(char)

			@return �폜��������������菜����������(String)
		</p>
	**/
	public static String characterDeleter(String st , char c)
	{

		//return�p������
		String s_str = "";

		//����������ꕶ�������ׁA�폜��������������菜���B
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//�ꕶ�����폜�����������Ɣ�r����B
			if ( c != st.charAt(i))
			{
				s_str = s_str + new Character(st.charAt(i)).toString();
			}
		}

		return s_str;
	}

	/**
		<p>
			���镶����z�񂩂�A����L�����N�^�[�������č폜����static���\�b�h

			@param s[] �ΏۃL�����N�^�[���폜���镶����z��
			@return str[] �ΏۃL�����N�^�[���폜����������z��
		</p>
	**/
	public static String[] characterDeleterArray(String s[] , char c)
	{
		String[] str = new String[s.length];

		for (int i = 0 ; i < s.length ; i++)
		{
			str[i] = StaticStringProcesser.characterDeleter(s[i] , c);
		}

		return str;
	}


	/**
		<p>
			������(String)�ƕϊ�������������(String)�ƕϊ����镶��(String)���󂯎��A
			����������������ϊ�����static���\�b�h�ł��B

			@param st �Ώە�����(String)
			@param ch_st �ϊ�������������(String)
			@param af_st �ϊ����镶����(String)

			@return �ϊ���̕�����(String)
		</p>
	**/
	public static String stringChanger(String st , String ch_st , String af_st)
	{
		//return�p������
		String s_str = "";

		//�����Bst�̒�����ch_st,af_st�̒�����蒷���Ȃ���Ύ��s���Ȃ��B
		if( st.length() > ch_st.length())
		{
			if( st.length() > af_st.length())
			{

				//����������ꕶ�������ׁA�폜��������������菜���B
				for ( int i = 0 ; i < st.length() ; i++)
				{
					//i + �ϊ�������������̒��� < �Ώە�����̒����Ȃ�Ύ��s����B
					if ( i + ch_st.length() < st.length())
					{
						//ch_st�̒���������������𒊏o����r����B
						if ( ch_st.equals(st.substring( i , i + ch_st.length())) == false)
						{
							//�ꕶ������return�������
							s_str = s_str + new String(st.substring( i , i+1));
						}
						else
						{
							//�ϊ���̕�����return������֑�����Ai�����̕��i�߂�B
							s_str = s_str + af_st;
							i = i + 2;
						}
					}
					else
					{
						//i + �ϊ�������������̒��� > �Ώە�����̒����Ȃ�Ύc��̑Ώە������
						//return������ɉ�����B
						s_str = s_str + new String(st.substring( i , i+1));
					}
				}

				return s_str;
			}
			else
			{
				System.out.println("af_st�̕����Ώە������蒷��");
				return "af_st�̕����Ώە������蒷��";
			}

		}
		else
		{

			System.out.println("ch_st�̕����Ώە������蒷��");
			return "ch_st�̕����Ώە������蒷��";
		}

	}

	/**
		<p>
			������(String)�ƑO��ɕt����������(char)���󂯎��A
			�������return���܂��B

			@param st �Ώە�����(String)
			@param ch �t������������(char)

			@return �ϊ���̕�����(String)
		</p>
	**/
	public static String characterBeforeAndAfter(String st , char ch)
	{
		//�t�����ĕԂ�
		return new Character(ch).toString() + st + new Character(ch).toString();
	}

	/**
		<p>
			�Œ蒷�̃f�[�^���ϒ��̃f�[�^�ɕϊ����鎖��z�肵�č�������\�b�h�ł��B
			�^����ꂽ������ɑ΂��A���K�̃f�[�^�̌��ɃZ�b�g���ꂽ�󔒂��폜���A
			���K�̃f�[�^�݂̂ɕϊ�����static���\�b�h�ł��B
			���ۂ͋󔒂��Q�A���������ꍇ�A���̂Q�A���̋󔒊܂߁A
			�ȍ~���폜���܂��B
			(�S�p�A���p��킸)

			@param st �Ώە�����(String)

			@return �]�v�ȋ󔒂��폜����������B
		</p>
	**/
	public static String afterSpaceTrimer(String st)
	{
		//�󂯎���������񂪋󂾂����ꍇ�A����return���Ė߂�
		if(st.equals(""))
			return st;

		//return�p������
		String s_str = "";

		//����������ꕶ�������ׁA�󔒂��A�����Ă��Ȃ������ׂ�B
		//�����͕����񒷂�-1�܂Œ��ׂ�B
		for ( int i = 0 ; i < st.length() - 1 ; i++)
		{

			//�܂����p�̋󔒂𒲂ׂ�B
			if ( st.charAt(i) == ' ')
			{

				if ( st.charAt(i + 1) == ' ')
				{
					//�����_�܂ł̕������Ԃ��B
					return s_str;
				}
				else if( st.charAt(i + 1 ) == '�@')
				{
					//�����_�܂ł̕������Ԃ��B
					return s_str;
				}

				//������̋󔒂͕K�v�Ȃ��̂Ɣ��f���A������ɒǉ�����B
				else
				{
					s_str = s_str + new Character(st.charAt(i)).toString();
				}
			}
			//�S�p�̋󔒂ɂ��Ē��ׂ�B
			else if ( st.charAt(i) == '�@')
			{

				if ( st.charAt(i + 1) == '�@')
				{
					//�����_�܂ł̕������Ԃ��B
					return s_str;
				}
				else if( st.charAt(i + 1 ) == ' ')
				{
					//�����_�܂ł̕������Ԃ��B
					return s_str;
				}

				//������̋󔒂͕K�v�Ȃ��̂Ɣ��f���A������ɒǉ�����B
				else
				{
					s_str = s_str + new Character(st.charAt(i)).toString();
				}
			}
			else
			{
				s_str = s_str + new Character(st.charAt(i)).toString();
			}
		}

		//�ŏI�������󔒂������ꍇ�̏���
		if (st.charAt(st.length() - 1 ) == ' ')
		{
			return s_str;
		}
		else if ( st.charAt(st.length() - 1 ) == '�@')
		{
			return s_str;
		}
		else
		{
			s_str = s_str + new Character(st.charAt(st.length() - 1)).toString();
		}

		return s_str;
	}

	/**
		<p>
			������(String)����Null�R�[�h����菜��static���\�b�h�ł��B

			@param st �Ώە�����(String)

			@return Null�R�[�h����菜����������(String)
		</p>
	**/
	public static String nullCodeDeleter(String st)
	{

		//return�p������
		String s_str = "";

		//����������ꕶ�������ׁA�폜��������������菜���B
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//�ꕶ������Null�R�[�h�����f����B
			if (new Character(st.charAt(i)).hashCode() != 0)
			{
				s_str = s_str + new Character(st.charAt(i)).toString();
			}
		}

		return s_str;
	}

	/**
		<p>
			������(String)����ŏ���1��������菜��static���\�b�h�ł��B

			@param st �Ώە�����(String)

			@return �P������菜����������(String)
		</p>
	 **/
	public static String oneCharacterDeleter(String st)
	{

		//return�p������
		String s_str = "";

		//����������ꕶ�������ׁA�폜��������������菜���B
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//�ꕶ���̂ݏ��O����B
			if (i != 0)
			{
				s_str = s_str + st.charAt(i);
			}
		}

		return s_str;
	}

	/**
		<p>
			������(String)����Ō��1��������菜��static���\�b�h�ł��B

			@param st �Ώە�����(String)

			@return �P������菜����������(String)
		</p>
	 **/
	public static String oneCharacterDeleterLast(String st)
	{

		//return�p������
		String s_str = "";

		//����������ꕶ�������ׁA�폜��������������菜���B
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//�Ō�̈ꕶ���i�܂�length-1�j�łȂ�������ԋp������֒ǉ��B
			if (i != (st.length() - 1))
			{
				s_str = s_str + st.charAt(i);
			}
		}

		return s_str;
	}

	/**
		<p>
			������(String)����w��̕������Ő؂���static���\�b�h�ł��B

			@param st �Ώە�����(String)
			@param num �w�肷�镶����

			@return ��������������(String)
		</p>
	 **/
	public static String orderNumCutter(String st , int num)
	{
		//return�p������
		String s_str = "";

		if(num > st.length())
		{
			for ( int i = 0 ; i < st.length() ; i++)
			{
				s_str = s_str + st.charAt(i);
			}
		}
		else
		{
			for ( int i = 0 ; i < num ; i++)
			{
				s_str = s_str + st.charAt(i);
			}
		}


		return s_str;
	}

	/**
		<p>
			������(String)����w��̕������ȍ~�݂̂ɂ���static���\�b�h�ł��B

			@param st �Ώە�����(String)
			@param num �w�肷�镶����

			@return ��������������(String)
		</p>
	 **/
	public static String orderRestNumCutter(String st , int num)
	{
		//return�p������
		String s_str = "";

		if(num < st.length())
		{
			for ( int i = 0 ; i < st.length() ; i++)
			{
				if (i >= num)
				{
					s_str = s_str + st.charAt(i);
				}
			}
		}
		return s_str;
	}

	/**
		<p>
			�����񂪍Ō�̕������w�肳�ꂽchar�ŏI��邩�m�F���郁�\�b�h�ł��B

			@param s �����Ώە�����
			@param c �Ō�̕����Ɣ�r����char
			@return boolean ��v����Ȃ�true ��v���Ȃ��Ȃ�false
		</p>
	**/
	public static boolean characterCheckLast(String s , char c)
	{
		//�����ŗ^����ꂽ�����񂪋󂾂����ꍇ�̑Ώ�
		if(s.equals(""))
			return false;

		if (s.charAt(s.length() - 1) == c)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
		<p>
			�����񂪗^����ꂽ���������Ȃ����ǂ����m�F���郁�\�b�h�ł��B

			@param String s �����Ώە�����
			@param int num ������������int
			@return boolean �������ȓ��Ȃ�true ��������蒷���Ȃ�false
		</p>
	**/
	public static boolean lengthCheck(String s , int num)
	{
		if (s.length() > num)
			return false;
		return true;
	}

}
