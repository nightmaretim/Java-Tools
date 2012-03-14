package editool.tool;

/**
	<p>
		固定のバイト数の文字列を作成するクラスです。
		バイト数、文字列、埋める文字はコンストラクタにて受け取ります。
		文字列に空きがある場合は、埋める文字で埋めます。
		文字列がはみ出した場合、切り捨てるため、文字列の切捨ての有無を
		メソッドで提供します。
		このクラスを使用時はコンストラクタに目的の文字列とバイト数を渡した後、
		先にrightOrWrong()メソッドで可否をbooleanで受け取って判断してください。
	</p>
**/

public class FixedBytesStringMaker
{
	/**
		<p>
			初期化コンストラクタ。
		</p>
	**/
	public FixedBytesStringMaker()
	{
		//初期化
		byte_num = 12;
		byte_string = "初期データ";
		spacer = DEFAULT_SPACER;
		byte_flag= true;
	}

	/**
		<p>
			バイト数、対象文字列を受け取るコンストラクタです。
			埋める文字はデフォルトの半角スペースです。

			@param bn 目的のバイト数
			@param bs 対象の文字列
		</p>
	**/
	public FixedBytesStringMaker(int bn , String bs)
	{
		this();

		//以降、目的バイト数と対象文字列の調査し、
		//目的バイト数が対象文字列バイト数より多い場合、
		//コンストラクタの値を代入する。
		byte bs_check[] = bs.getBytes();
		if ( bn >= bs_check.length)
		{

			//値の受け取り
			byte_num = bn;
			byte_string = bs;

		}
		else
		{
			//値を受け取らず、デフォルトのまま
			//フラグをfalseに。
			byte_flag = false;
		}
	}

	/**
		<p>
			バイト数、対象文字列、埋める文字を受け取るコンストラクタです。

			@param bn 目的のバイト数
			@param bs 対象の文字列
			@param sp 埋める文字
		</p>
	**/
	public FixedBytesStringMaker(int bn , String bs , String sp)
	{
		this();

		//以降、目的バイト数と対象文字列の調査し、
		//目的バイト数が対象文字列バイト数より多い場合、
		//コンストラクタの値を代入する。
		byte bs_check[] = bs.getBytes();
		if ( bn >= bs_check.length)
		{

			//値の受け取り
			byte_num = bn;
			byte_string = bs;

		}
		else
		{
			//値を受け取らず、デフォルトのまま
			//フラグをfalseに。
			byte_flag = false;
		}

		//以降、埋める文字の半角(1バイト)チェック
		//1バイトで無い場合、デフォルトの埋める文字を使用する。
		byte sp_check[] = sp.getBytes();
		if(sp_check.length == 1)
		{
			spacer = sp;
		}

	}

	/**
		<p>
			目的バイト数と対象文字列のバイト数の
			大きさから、実行の可否をbooleanで返すメソッド。

			@return 可否を知らせるboolean変数。trueなら可。falseなら不可。
		</p>
	**/
	public boolean rightOrWrong()
	{
		return byte_flag;
	}

	/**
		<p>
			対象文字列を目的バイト数に揃えた文字列に変換するメソッド。

			@return 目的バイト数に揃えたStringオブジェクト
		</p>
	**/
	public String converter()
	{
		//受け取りbyte配列
		byte temp_byte[] = new byte[byte_num];
		//埋める文字用byte配列
		byte tb_sp[] = spacer.getBytes();

		//byte配列を埋める文字で代入
		for (int i = 0 ; i < temp_byte.length ; i++)
		{
			temp_byte[i] = tb_sp[0];
		}

		//対象文字列をbyte化し、バイトを揃え、
		//文字列に再度戻す。
		//変換用バイト配列
		byte tb_bs[] = byte_string.getBytes();
		for (int i = 0 ; i < tb_bs.length ; i++)
		{
			temp_byte[i] = tb_bs[i];
		}

		//作成した文字列を返す。
		return new String(temp_byte);
	}

	//目的バイト数を格納する変数
	private int byte_num;
	//対象の文字列を格納する変数
	private String byte_string;
	//埋める文字を格納する変数
	private String spacer;
	//文字列と目的バイト数を切り捨ての有無を保管するフラグ
	private boolean byte_flag;

	//埋める文字が半角でなかった時の、デフォルト文字
	private final String DEFAULT_SPACER = " ";
}
