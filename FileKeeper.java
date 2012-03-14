package editool.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
	<p>
		ファイルを記録するクラスです。フィールドとしてファイル出力用のクラスや
		対象ディレクトリやファイルを示すFileオブジェクトを持ちます。
		各種メソッドを使用して使用条件を整え、ログを記録します。
	</p>
**/
public class FileKeeper
{
	//ファイル用出力クラス

	//対象ディレクトリと対象ファイル用
	private InDirectoryFile target_idf;
	private final String EXTENSION = ".dat";

	public FileKeeper()
	{
		//対象ディレクトリと対象ファイル
		target_idf = new InDirectoryFile();
	}

	/**
		<p>
			対象ディレクトリがファイルとして成立するか調査します。
			出来なければIOExceptionを吐き出します。

			@throws IOException
		</p>
	 **/
	public boolean setTargetBaseDir(String targetbase) throws IOException
	{
		target_idf = new InDirectoryFile(targetbase);

		return target_idf.targetInvestigation();

	}

	/**
		<p>
			sourceファイルをtargetディレクトリに
			名前を変えてコピーします。

			@param String keep後ファイルの基本名
			@return String コピー元のファイル名→コピー先のファイル名
			@throws IOException
		</p>
	 **/
	public String fileKeep(String filename,File sourcefile) throws IOException
	{
		if(!target_idf.targetInvestigation())
		{
			return "nokeep";
		}

		String time = TimeTool.getNowTime();
		File targetfile = target_idf.setFile(filename+time+EXTENSION);

		FileChannel targetchannel = new FileOutputStream(targetfile).getChannel();
		FileChannel sourcechannel = new FileInputStream(sourcefile).getChannel();
		sourcechannel.transferTo(0, sourcechannel.size(), targetchannel);
        sourcechannel.close();
        targetchannel.close();

        return sourcefile.getName() + "は、"+ targetfile.getName() + "に変換されました。";
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
	public int oldestFileDeleter(int filenum) throws IOException
	{
		int count = 0;

		if(!target_idf.targetInvestigation())
		{
			return -1;
		}

		count = target_idf.oldestFileNameDeleter(filenum);

		return count;
	}

}
