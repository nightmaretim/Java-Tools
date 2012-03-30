//StaticStringProcesser.java

package editool.tool;

/**
	<p>
		文字列でよく行う事をまとめたstaticクラスです。
	</p>
**/

public class StaticStringProcesser
{

	/**
		<p>
			staticメソッドだけなので、コンストラクタを必要としません。
		</p>
	**/
	public StaticStringProcesser()
	{
	}

	/**
		<p>
			文字列(String)と削除したい文字(char)を受け取り、文字列内から削除したい文字を
			取り除くstaticメソッドです。

			@param st 対象文字列(String)
			@param c 削除したい文字(char)

			@return 削除したい文字を取り除いた文字列(String)
		</p>
	**/
	public static String characterDeleter(String st , char c)
	{

		//return用文字列
		String s_str = "";

		//文字列内を一文字ずつ調べ、削除したい文字を取り除く。
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//一文字ずつ削除したい文字と比較する。
			if ( c != st.charAt(i))
			{
				s_str = s_str + new Character(st.charAt(i)).toString();
			}
		}

		return s_str;
	}

	/**
		<p>
			ある文字列配列から、あるキャラクターを見つけて削除するstaticメソッド

			@param s[] 対象キャラクターを削除する文字列配列
			@return str[] 対象キャラクターを削除した文字列配列
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
			文字列(String)と変換したい文字列(String)と変換する文字(String)を受け取り、
			文字列内を検索し変換するstaticメソッドです。

			@param st 対象文字列(String)
			@param ch_st 変換したい文字列(String)
			@param af_st 変換する文字列(String)

			@return 変換後の文字列(String)
		</p>
	**/
	public static String stringChanger(String st , String ch_st , String af_st)
	{
		//return用文字列
		String s_str = "";

		//検査。stの長さがch_st,af_stの長さより長くなければ実行しない。
		if( st.length() > ch_st.length())
		{
			if( st.length() > af_st.length())
			{

				//文字列内を一文字ずつ調べ、削除したい文字を取り除く。
				for ( int i = 0 ; i < st.length() ; i++)
				{
					//i + 変換したい文字列の長さ < 対象文字列の長さならば実行する。
					if ( i + ch_st.length() < st.length())
					{
						//ch_stの長さ分だけ文字列を抽出し比較する。
						if ( ch_st.equals(st.substring( i , i + ch_st.length())) == false)
						{
							//一文字ずつreturn文字列へ
							s_str = s_str + new String(st.substring( i , i+1));
						}
						else
						{
							//変換後の文字をreturn文字列へ代入し、iをその分進める。
							s_str = s_str + af_st;
							i = i + 2;
						}
					}
					else
					{
						//i + 変換したい文字列の長さ > 対象文字列の長さならば残りの対象文字列を
						//return文字列に加える。
						s_str = s_str + new String(st.substring( i , i+1));
					}
				}

				return s_str;
			}
			else
			{
				System.out.println("af_stの方が対象文字列より長い");
				return "af_stの方が対象文字列より長い";
			}

		}
		else
		{

			System.out.println("ch_stの方が対象文字列より長い");
			return "ch_stの方が対象文字列より長い";
		}

	}

	/**
		<p>
			文字列(String)と前後に付けたい文字(char)を受け取り、
			文字列をreturnします。

			@param st 対象文字列(String)
			@param ch 付属したい文字(char)

			@return 変換後の文字列(String)
		</p>
	**/
	public static String characterBeforeAndAfter(String st , char ch)
	{
		//付属して返す
		return new Character(ch).toString() + st + new Character(ch).toString();
	}

	/**
		<p>
			固定長のデータを可変長のデータに変換する事を想定して作ったメソッドです。
			与えられた文字列に対し、正規のデータの後ろにセットされた空白を削除し、
			正規のデータのみに変換するstaticメソッドです。
			実際は空白が２連続続いた場合、その２連続の空白含め、
			以降を削除します。
			(全角、半角問わず)

			@param st 対象文字列(String)

			@return 余計な空白を削除した文字列。
		</p>
	**/
	public static String afterSpaceTrimer(String st)
	{
		//受け取った文字列が空だった場合、すぐreturnして戻る
		if(st.equals(""))
			return st;

		//return用文字列
		String s_str = "";

		//文字列内を一文字ずつ調べ、空白が連続していないか調べる。
		//検査は文字列長さ-1まで調べる。
		for ( int i = 0 ; i < st.length() - 1 ; i++)
		{

			//まず半角の空白を調べる。
			if ( st.charAt(i) == ' ')
			{

				if ( st.charAt(i + 1) == ' ')
				{
					//現時点までの文字列を返す。
					return s_str;
				}
				else if( st.charAt(i + 1 ) == '　')
				{
					//現時点までの文字列を返す。
					return s_str;
				}

				//一つだけの空白は必要なものと判断し、文字列に追加する。
				else
				{
					s_str = s_str + new Character(st.charAt(i)).toString();
				}
			}
			//全角の空白について調べる。
			else if ( st.charAt(i) == '　')
			{

				if ( st.charAt(i + 1) == '　')
				{
					//現時点までの文字列を返す。
					return s_str;
				}
				else if( st.charAt(i + 1 ) == ' ')
				{
					//現時点までの文字列を返す。
					return s_str;
				}

				//一つだけの空白は必要なものと判断し、文字列に追加する。
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

		//最終文字が空白だった場合の処理
		if (st.charAt(st.length() - 1 ) == ' ')
		{
			return s_str;
		}
		else if ( st.charAt(st.length() - 1 ) == '　')
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
			文字列(String)からNullコードを取り除くstaticメソッドです。

			@param st 対象文字列(String)

			@return Nullコードを取り除いた文字列(String)
		</p>
	**/
	public static String nullCodeDeleter(String st)
	{

		//return用文字列
		String s_str = "";

		//文字列内を一文字ずつ調べ、削除したい文字を取り除く。
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//一文字ずつNullコードか判断する。
			if (new Character(st.charAt(i)).hashCode() != 0)
			{
				s_str = s_str + new Character(st.charAt(i)).toString();
			}
		}

		return s_str;
	}

	/**
		<p>
			文字列(String)から最初の1文字を取り除くstaticメソッドです。

			@param st 対象文字列(String)

			@return １文字取り除いた文字列(String)
		</p>
	 **/
	public static String oneCharacterDeleter(String st)
	{

		//return用文字列
		String s_str = "";

		//文字列内を一文字ずつ調べ、削除したい文字を取り除く。
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//一文字のみ除外する。
			if (i != 0)
			{
				s_str = s_str + st.charAt(i);
			}
		}

		return s_str;
	}

	/**
		<p>
			文字列(String)から最後の1文字を取り除くstaticメソッドです。

			@param st 対象文字列(String)

			@return １文字取り除いた文字列(String)
		</p>
	 **/
	public static String oneCharacterDeleterLast(String st)
	{

		//return用文字列
		String s_str = "";

		//文字列内を一文字ずつ調べ、削除したい文字を取り除く。
		for ( int i = 0 ; i < st.length() ; i++)
		{
			//最後の一文字（つまりlength-1）でなかったら返却文字列へ追加。
			if (i != (st.length() - 1))
			{
				s_str = s_str + st.charAt(i);
			}
		}

		return s_str;
	}

	/**
		<p>
			文字列(String)から指定の文字数で切り取るstaticメソッドです。

			@param st 対象文字列(String)
			@param num 指定する文字数

			@return 処理した文字列(String)
		</p>
	 **/
	public static String orderNumCutter(String st , int num)
	{
		//return用文字列
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
			文字列(String)から指定の文字数以降のみにするstaticメソッドです。

			@param st 対象文字列(String)
			@param num 指定する文字数

			@return 処理した文字列(String)
		</p>
	 **/
	public static String orderRestNumCutter(String st , int num)
	{
		//return用文字列
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
			文字列が最後の文字が指定されたcharで終わるか確認するメソッドです。

			@param s 調査対象文字列
			@param c 最後の文字と比較するchar
			@return boolean 一致するならtrue 一致しないならfalse
		</p>
	**/
	public static boolean characterCheckLast(String s , char c)
	{
		//引数で与えられた文字列が空だった場合の対処
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
			文字列が与えられた文字数いないかどうか確認するメソッドです。

			@param String s 調査対象文字列
			@param int num 文字数を示すint
			@return boolean 文字数以内ならtrue 文字数より長いならfalse
		</p>
	**/
	public static boolean lengthCheck(String s , int num)
	{
		if (s.length() > num)
			return false;
		return true;
	}

}
