//StringDivider.java

package editool.tool;

import java.util.Vector;


/**
	<p>
		与えられた文字列を与えられた条件で分割し、文字列の配列にして返すクラスです。
	</p>
**/
public class StringDivider
{

	//分割対象の文字列
	private String db_string;
	//分割後の格納ベクトル
	private Vector<String> r_vector;
	//デリミタを使用するときに格納する変数
	private char delimiter;
	//文字数で分割する時の数値を格納する変数
	private int d_num[];

	/**
		<p>
			初期化コンストラクタ。
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
			デリミタを用いた分割を行う際のコンストラクタ。
			文字列とデリミタ文字を受け取る。

			@param st 分割する文字列
			@param d デリミタとなる文字
		</p>
	**/
	public StringDivider(String st , char d)
	{
		this();

		//文字列格納
		db_string = st;
		//デリミタ文字格納
		delimiter = d;

	}

	/**
		<p>
			デリミタを用いた分割を行う際のコンストラクタ。
			文字列とデリミタ文字を受け取る。

			@param st 分割する文字列
			@param num 分割する際に使用する文字数を格納したint配列
		</p>
	 **/
	public StringDivider(String st , int num[])
	{
		this();

		//文字列格納
		db_string = st;
		//分割文字列の配列格納
		d_num = num;

	}

	/**
		<p>
			デリミタを用いた分割を行うメソッド。
			分割した文字列を文字列配列に格納して
			returnする。

			@return 分割した文字列の配列
		</p>
	**/
	public String[] delimiterDivider()
	{
		//一時保管用文字列変数
		String temp = "";

		for (int i = 0 ; i < db_string.length() ; i++)
		{
			if(db_string.charAt(i) == delimiter)
			{
				//ベクトルに格納
				r_vector.add(temp);
				//temp初期化
				temp = "";

			}
			else
			{
				temp = temp + db_string.charAt(i);
			}

		}

		//ループ終了後、tempに文字があれば、
		//ベクトルに追加する
		if (temp.equals("")==false)
		{
			//ベクトルに追加
			r_vector.add(temp);
			temp="";
		}

		//return文字列配列
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
		}

		return r_string;
	}

	/**
	<p>
		デリミタを用いた分割を行うメソッド。
		分割した文字列を文字列配列に格納して
		returnする。
		但し、paramで受け取ったcharで囲まれた部分があった場合、
		その間での分割は行わないようにする。

		@param char 保護する文字列の前後に置かれるchar
		@return 分割した文字列の配列
	</p>
**/
public String[] delimiterDividerWith(char c)
{
	//一時保管用文字列変数
	String temp = "";
	boolean flag = false;

	for (int i = 0 ; i < db_string.length() ; i++)
	{
		if(db_string.charAt(i) == delimiter && !flag)
		{
			//ベクトルに格納
			r_vector.add(temp);
			//temp初期化
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

	//ループ終了後、tempに文字があれば、
	//ベクトルに追加する
	if (temp.equals("")==false)
	{
		//ベクトルに追加
		r_vector.add(temp);
		temp="";
	}

	//return文字列配列
	String r_string[] = new String[r_vector.size()];
	for(int i = 0 ; i < r_vector.size() ; i++)
	{
		r_string[i] = (String)r_vector.elementAt(i);
	}

	return r_string;
}

	/**
		<p>
			分割文字数が書かれた配列を用いた分割を行うメソッド。
			分割した文字列を文字列配列に格納して
			returnする。

			付帯機能として、スペースを除去する

			@return 分割した文字列の配列
		</p>
	 **/
	public String[] numArrangementDividerSpaceTrim()
	{
		//一時保管用文字列変数
		String temp = "";

		int a = 0;
		int b = 0;

		for (int i = 0 ; i < db_string.length() ; i++)
		{



			if(a == d_num[b])
			{
				//ベクトルに格納
				r_vector.add(temp);
				//temp初期化
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

		//ループ終了後、tempに文字があれば、
		//ベクトルに追加する
		if (temp.equals("")==false)
		{
			//ベクトルに追加
			r_vector.add(temp);
			temp="";
		}

		//return文字列配列
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
			分割文字数が書かれた配列を用いた分割を行うメソッド。
			分割した文字列を文字列配列に格納して
			returnする。

			@return 分割した文字列の配列
		</p>
	 **/
	public String[] numArrangementDivider()
	{
		//一時保管用文字列変数
		String temp = "";

		int a = 0;
		int b = 0;

		for (int i = 0 ; i < db_string.length() ; i++)
		{



			if(a == d_num[b])
			{
				//ベクトルに格納
				r_vector.add(temp);
				//temp初期化
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

		//ループ終了後、tempに文字があれば、
		//ベクトルに追加する
		if (temp.equals("")==false)
		{
			//ベクトルに追加
			r_vector.add(temp);
			temp="";
		}

		//return文字列配列
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
		}

		return r_string;
	}

	/**
		<p>
			分割文字数が書かれた配列を用いた分割を行うメソッド。
			分割した文字列を文字列配列に格納して
			returnする。
			バイト配列を用いるため、半角、全角を正確に分割する。

			@return 分割した文字列の配列
		</p>
	 **/
	public String[] numArrangementDividerByte()
	{
		//文字列分割のためのtemp
		int a = 0;
		//バイト配列
		byte by[] = db_string.getBytes();

		for (int i = 0 ; i < d_num.length ; i++)
		{

			byte bytemp[] = new byte[d_num[i]];

			for (int j = 0 ; j < d_num[i] ; j++)
			{
				bytemp[j] = by[a + j];
			}
			//ベクトルに格納
			r_vector.add(new String(bytemp));
			//次スタート数を保管
			a = a + d_num[i];

		}

		//return文字列配列
		String r_string[] = new String[r_vector.size()];
		for(int i = 0 ; i < r_vector.size() ; i++)
		{
			r_string[i] = (String)r_vector.elementAt(i);
		}

		return r_string;
	}

	/**
		<p>
			分割文字数が書かれた配列を用いた分割を行うメソッド。
			分割した文字列を文字列配列に格納して
			returnする。
			バイト配列を用いるため、半角、全角を正確に分割する。

			付加機能として、スペースを削除する。

			@return 分割した文字列の配列
		</p>
	 **/
	public String[] numArrangementDividerByteSpaceTrim()
	{
		//文字列分割のためのtemp
		int a = 0;
		//バイト配列
		byte by[] = db_string.getBytes();

		for (int i = 0 ; i < d_num.length ; i++)
		{

			byte bytemp[] = new byte[d_num[i]];

			for (int j = 0 ; j < d_num[i] ; j++)
			{
				bytemp[j] = by[a + j];
			}
			//ベクトルに格納
			r_vector.add(new String(bytemp));
			//次スタート数を保管
			a = a + d_num[i];

		}

		//return文字列配列
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
			分割文字数が書かれた配列を用いた分割を行う前に、
			与えられた文字列の長さと、与えられた分割用数字配列の
			合計数の関係から、分割の成否を判断するメソッド
			与えられた文字列の長さ>=与えられた分割用数字配列の合計　true
			                      <                                 false

			@return Boolean 成否
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
			分割文字数が書かれた配列を用いた分割を行う前に、
			与えられた文字列(バイト)の長さと、与えられた分割用数字配列の
			合計数の関係から、分割の成否を判断するメソッド
			与えられた文字列の長さ>=与えられた分割用数字配列の合計　true
			                      <                                 false

			@return Boolean 成否
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
