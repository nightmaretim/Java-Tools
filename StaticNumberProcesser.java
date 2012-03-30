package editool.tool;

/**
	<p>
		数字に関していろいろ処理を行うStaticクラスです。
	</p>
**/

public class StaticNumberProcesser
{
	/**
		<p>
			文字列化した数値をFloat.parseFloatを使ってfloatに変換するメソッド。
			文字列がブランクの場合は、0を返す
			@param String float化する数値文字列
			@return float float化した数値
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
			文字列化した数値をDouble.parseDoubleを使ってdoubleに変換するメソッド。
			文字列がブランクの場合は、0を返す
			@param String double化する数値文字列
			@return double double化した数値
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
			文字列化した数値をInteger.parseIntを使ってintに変換するメソッド。
			文字列がブランクの場合は、0を返す
			@param String int化する数値文字列
			@return int int化した数値
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
	 * 文字列型の数字を受け取り、2桁で揃える、つまり１桁なら前に0を補完するプログラムです。
	 *
	 * @param String 0を付加する文字列 ( 2文字以下)
	 * @return String ２桁に揃えた文字列
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
	 * 文字列型の数字の前の0をトリミングする。0以外の文字数字が出た時点で終了
	 *
	 * @param String 0をトリミングする文字列
	 * @return String トリミングした文字列
	 */
	public static String stringNumberZeroTrimer(String s) throws NumberFormatException
	{

		//return用文字列
		String s_str = "";
		//最初に0でない文字列数字が出たときのフラグ
		boolean flag = false;

		//文字列内を一文字ずつ調べ、0が連続していないか調べる。
		//検査は文字列長さ-1まで調べる。
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
	 * 数字の桁数を調べるために、数字と桁数数字を受け取り、
	 * 基数10の(桁数数字乗-1)で数字を割った商を返します。
	 *
	 * 例　引数　70,000 5
	 * 10の乗　10,000だから　7
	 * 例　引数　3,000 5
	 * 10の４乗　10,000だから　0.3　intに代入するから0
	 * 例　引数　400,000 5
	 * 10の４乗　10,000だから　40
	 * 10以上だった場合　桁あふれとしてfalseを返します
	 *
	 *
	 * @param int 対象の数字
	 * @param int 桁数の数字
	 * @return boolean 結果
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
	 * 少数の桁数を調べるために、数字と桁数数字（整数部、小数部）を受け取り、
	 * 判定します
	 *
	 * 例　引数　70.22,5,2
	 *   true
	 * 例　引数　805.235,5,2
	 *   false
	 *
	 * @param double 対象の数字
	 * @param int 整数部桁数の数字
	 * @param int 小数部桁数の数字
	 * @return boolean 結果
	 */
	public static boolean disitCheckDouble(double target , int disit_i , int disit_d)
	{
		//整数部 チェックはdisitCheckメソッドを利用
		final int base = 10;
		final int decimal_base = 1;
		int temp_int = 0;

		temp_int = (int)target;

		if (!disitCheck(temp_int , disit_i))
			return false;

		//小数部
		double temp_double = 0;
		temp_double = (target * Math.pow((double)base, (double)disit_d))%decimal_base;

		if(temp_double > 0)
			return false;

		return true;
	}
}
