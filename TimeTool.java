package editool.tool;

import java.util.Calendar;

/**
	<p>
		日付、時刻に対してよく使うメソッドを集めたStaticクラスです。
	</p>
	**/
public class TimeTool
{

	private static final int YEAR_LENGTH_LONG = 4;
	private static final int YEAR_LENGTH_SHORT = 2;

	/**
		<p>
			現在の日付、時刻を文字列にして返します。
			yyyymmddhhmmssです。

			@return String 現時刻の文字列

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
			月、日付、時間、分、秒などのために、1を01と文字列変換するためのクラスです。
			10以下の場合は0を付けて文字列化します。
			@param int 0をつける対象数値
			@return String 0をつけた文字列
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
			日付文字列yymmddをyyyymmddの文字列で返します。
			@param String yymmdd形式の日付文字列
			@return String yyyymmdd形式の文字列
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
			/で区切りの日付文字列yy/mm/ddをyyyymmddの文字列で返します。
			@param String /区切りの日付文字列
			@return String yyyymmdd形式の文字列
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
			/で区切りの日付文字列yy-mm-ddをyyyymmddの文字列で返します。
			@param String -区切りの日付文字列
			@return String yyyymmdd形式の文字列
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
			/で区切りの日付文字列yyyy/mm/ddをyyyymmddの文字列で返します。
			@param String /区切りの日付文字列yyyy/mm/dd
			@return String yyyymmdd形式の文字列
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
			年月日区切りの日付文字列yyyy年mm月dd日をyyyymmddの文字列で返します。
			@param String 年月日区切りの日付文字列
			@return String yyyymmdd形式の文字列
		</p>
	 **/
	public static String delNengappiParseYyyymmdd(String string)
	{
		string = StaticStringProcesser.characterDeleter(string, '年');
		string = StaticStringProcesser.characterDeleter(string, '月');
		string = StaticStringProcesser.characterDeleter(string, '日');

		return string;

	}

	/**
		<p>
			引数で渡されたyyyymm形式の年月を表したintを
			もうひとつのint引数で年月のルールに則って計算します。

			@param int 計算対象の年月int yyyymm形式
			@param int 足し込む数字 引きたい場合は-で
			@return int 計算結果yyyymmdd形式のint
		</p>
	 **/
	public static int sumIntYyyyMm(int ym , int sum_num)
	{
		final int MONTH = 12;
		final int SUM_MONTH = 100;

		//年月数字の月部分が12より大きかったらエラー -1
		if(ym%SUM_MONTH > MONTH)
		{
			return -1;
		}

		//計算対象の数字が12～-12の範囲内でなかったらエラー
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
			年月の日付文字列yy/mをyyyymmの文字列で返します。
			@param String /区切りの年月文字列
			@return String yyyymm形式の文字列
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
			年月の日付文字列yymmをyyyymmの文字列で返します。
			@param String yymm形式の文字列
			@return String yyyymm形式の文字列
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
			年月日の日付文字列m/dをyyyymmddの文字列で返します。
			yyyymm形式の年月を受け取って、足りない場合は保管します。
			@param String /区切りの年月日文字列
			@param String yyyymm形式の年月
			@return String yyyymmdd形式の文字列
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
			年月日の日付文字列dをyyyymmddの文字列で返します。
			yyyymm形式の年月を受け取って、足りない場合は保管します。
			@param String /区切りの年月日文字列
			@param String yyyymm形式の年月
			@return String yyyymmdd形式の文字列
		</p>
	 **/
	public static String delSlashDParseYyyymmdd(String d , String yyyymm)
	{

		return yyyymm + TimeTool.getTimePlusZero(Integer.parseInt(d));

	}

	/**
		<p>
			日付加減算プログラムです。
			yyyymmdd形式の日付を受け取り、もう一方の変数dを加減算し、
			yyyymmdd形式で返します。
			@param int ymd 計算対象の8桁int日付yyyymmdd
			@param int d 加減算する日数　int
			@return int 計算結果yyyymmdd形式の文字列
		</p>
	 **/
	public static int dateCalculationIntYyyymmdd(int ymd , int d)
	{
		final int YEAR_NUM = 10000;
		final int MONTH_NUM = 100;

		//ymdから年月日抽出
		int year = ymd / YEAR_NUM;
		int month = (ymd%YEAR_NUM) / MONTH_NUM;
		int day = ymd % MONTH_NUM;

		//ymdでCalendarオブジェクト作成
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, day);

		//dを加減算
		c.add(Calendar.DATE , d);

		//year,mounth,dayに展開
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DATE);

		//yyyymmdd形式にしてreturn
		return (year * YEAR_NUM) + (month * MONTH_NUM) + day;
	}

	/**
		<p>
			現在時刻をint型yyyymmdd形式で返すプログラムです。
			@return int yyyymmdd形式の現時刻
		</p>
	 **/
	public static int nowIntYyyymmdd()
	{
		final int YEAR_NUM = 10000;
		final int MONTH_NUM = 100;

		//ymdでCalendarオブジェクト作成
		Calendar c = Calendar.getInstance();

		//year,mounth,dayに展開
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);

		//yyyymmdd形式にしてreturn
		return (year * YEAR_NUM) + (month * MONTH_NUM) + day;
	}

	//現在の年の上位２ケタを返すプライベートメソッド
	private static int nowYearYy()
	{
		//ymdでCalendarオブジェクト作成
		Calendar c = Calendar.getInstance();

		//year,mounth,dayに展開
		int year = c.get(Calendar.YEAR);

		return year/100;
	}
}
