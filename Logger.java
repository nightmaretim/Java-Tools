package editool.tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
	<p>
		ログを記録するクラスです。フィールドとしてログファイル出力用のクラスや
		対象ディレクトリやファイルを示すFileオブジェクトを持ちます。
		各種メソッドを使用して使用条件を整え、ログを記録します。
	</p>
**/
public class Logger
{
	//ログファイル用出力クラス
	private FileOutputStream fos_log;
	private OutputStreamWriter osw_log;
	private BufferedWriter bw_log;

	//対象ディレクトリと対象ファイル用
	private InDirectoryFile idf;
	private File logfile;

	private final String EXTENSION = ".log";

	public Logger()
	{
		//ログファイル用出力クラス
		fos_log = null;
		osw_log = null;
		bw_log = null;

		//対象ディレクトリと対象ファイル
		idf =new InDirectoryFile();
		logfile = null;
	}

	/**
		<p>
			対象ディレクトリがファイルとして成立するか調査します。
			出来なければIOExceptionを吐き出します。

			@throws IOException
		</p>
	 **/
	public boolean setBaseDir(String basedir) throws IOException
	{
		idf = new InDirectoryFile(basedir);

		return idf.targetInvestigation();
	}

	/**
		<p>
			対象ディレクトリにログファイルを作成します。
			ログファイル名は引数のfilename＋現在の日付時間.logです。
			出来なければIOExceptionを吐き出します。

			@throws IOException
		</p>
	 **/
	public boolean setLogFile(String filename) throws IOException
	{
		if(!idf.targetInvestigation())
		{
			return false;
		}

		String time = TimeTool.getNowTime();
		logfile = idf.setFile(filename+time+EXTENSION);

		fos_log = new FileOutputStream(logfile);
		osw_log = new OutputStreamWriter(fos_log);
		bw_log = new BufferedWriter(osw_log);

		return true;
	}

	/**
		<p>
			対象ディレクトリの一番古いログを削除します。
			引数で残しておくログ数を渡し、その数より
			対象ディレクトリのファイル数が多かった場合、
			ファイル名で一番若いと判断されたファイルを削除します。
			削除したファイル数を返します。
			何も対象ディレクトリ判断失敗時は-1を返します。

			@param int 残したいファイル数
			@return int 削除したファイル数

			@throws IOException
		</p>
	 **/
	public int oldestLogDeleter(int lognum) throws IOException
	{
		int count = 0;

		if(!idf.targetInvestigation())
		{
			return -1;
		}

		count = idf.oldestFileNameDeleter(lognum);

		return count;
	}

	/**
		<p>
			ファイルにログを書き込みます。
			現時刻を付帯して書き込みます。

			@param String 書き込みたい文字列
			@return int 削除したファイル数

			@throws IOException
		</p>
	 **/
	public void writeLog(String logstr) throws IOException
	{
		if(bw_log!=null)
		{
			bw_log.write(TimeTool.getNowTime() + logstr);
			bw_log.newLine();
		}
	}

	/**
	<p>
		loggerをクローズします。
		setLogFileを実行したあとは必ずこのメソッドで
		BufferdWriterをクローズします。

		@param int 残したいファイル数
		@return int 削除したファイル数

		@throws IOException
	</p>
 **/
	public void close() throws IOException
	{
		//bw_logライターのクローズ
		try
		{
			if (bw_log != null)
			{
				bw_log.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
