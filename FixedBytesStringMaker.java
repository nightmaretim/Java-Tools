package editool.tool;

/**
	<p>
		�Œ�̃o�C�g���̕�������쐬����N���X�ł��B
		�o�C�g���A������A���߂镶���̓R���X�g���N�^�ɂĎ󂯎��܂��B
		������ɋ󂫂�����ꍇ�́A���߂镶���Ŗ��߂܂��B
		�����񂪂͂ݏo�����ꍇ�A�؂�̂Ă邽�߁A������̐؎̂Ă̗L����
		���\�b�h�Œ񋟂��܂��B
		���̃N���X���g�p���̓R���X�g���N�^�ɖړI�̕�����ƃo�C�g����n������A
		���rightOrWrong()���\�b�h�ŉۂ�boolean�Ŏ󂯎���Ĕ��f���Ă��������B
	</p>
**/

public class FixedBytesStringMaker
{
	/**
		<p>
			�������R���X�g���N�^�B
		</p>
	**/
	public FixedBytesStringMaker()
	{
		//������
		byte_num = 12;
		byte_string = "�����f�[�^";
		spacer = DEFAULT_SPACER;
		byte_flag= true;
	}

	/**
		<p>
			�o�C�g���A�Ώە�������󂯎��R���X�g���N�^�ł��B
			���߂镶���̓f�t�H���g�̔��p�X�y�[�X�ł��B

			@param bn �ړI�̃o�C�g��
			@param bs �Ώۂ̕�����
		</p>
	**/
	public FixedBytesStringMaker(int bn , String bs)
	{
		this();

		//�ȍ~�A�ړI�o�C�g���ƑΏە�����̒������A
		//�ړI�o�C�g�����Ώە�����o�C�g����葽���ꍇ�A
		//�R���X�g���N�^�̒l��������B
		byte bs_check[] = bs.getBytes();
		if ( bn >= bs_check.length)
		{

			//�l�̎󂯎��
			byte_num = bn;
			byte_string = bs;

		}
		else
		{
			//�l���󂯎�炸�A�f�t�H���g�̂܂�
			//�t���O��false�ɁB
			byte_flag = false;
		}
	}

	/**
		<p>
			�o�C�g���A�Ώە�����A���߂镶�����󂯎��R���X�g���N�^�ł��B

			@param bn �ړI�̃o�C�g��
			@param bs �Ώۂ̕�����
			@param sp ���߂镶��
		</p>
	**/
	public FixedBytesStringMaker(int bn , String bs , String sp)
	{
		this();

		//�ȍ~�A�ړI�o�C�g���ƑΏە�����̒������A
		//�ړI�o�C�g�����Ώە�����o�C�g����葽���ꍇ�A
		//�R���X�g���N�^�̒l��������B
		byte bs_check[] = bs.getBytes();
		if ( bn >= bs_check.length)
		{

			//�l�̎󂯎��
			byte_num = bn;
			byte_string = bs;

		}
		else
		{
			//�l���󂯎�炸�A�f�t�H���g�̂܂�
			//�t���O��false�ɁB
			byte_flag = false;
		}

		//�ȍ~�A���߂镶���̔��p(1�o�C�g)�`�F�b�N
		//1�o�C�g�Ŗ����ꍇ�A�f�t�H���g�̖��߂镶�����g�p����B
		byte sp_check[] = sp.getBytes();
		if(sp_check.length == 1)
		{
			spacer = sp;
		}

	}

	/**
		<p>
			�ړI�o�C�g���ƑΏە�����̃o�C�g����
			�傫������A���s�̉ۂ�boolean�ŕԂ����\�b�h�B

			@return �ۂ�m�点��boolean�ϐ��Btrue�Ȃ�Bfalse�Ȃ�s�B
		</p>
	**/
	public boolean rightOrWrong()
	{
		return byte_flag;
	}

	/**
		<p>
			�Ώە������ړI�o�C�g���ɑ�����������ɕϊ����郁�\�b�h�B

			@return �ړI�o�C�g���ɑ�����String�I�u�W�F�N�g
		</p>
	**/
	public String converter()
	{
		//�󂯎��byte�z��
		byte temp_byte[] = new byte[byte_num];
		//���߂镶���pbyte�z��
		byte tb_sp[] = spacer.getBytes();

		//byte�z��𖄂߂镶���ő��
		for (int i = 0 ; i < temp_byte.length ; i++)
		{
			temp_byte[i] = tb_sp[0];
		}

		//�Ώە������byte�����A�o�C�g�𑵂��A
		//������ɍēx�߂��B
		//�ϊ��p�o�C�g�z��
		byte tb_bs[] = byte_string.getBytes();
		for (int i = 0 ; i < tb_bs.length ; i++)
		{
			temp_byte[i] = tb_bs[i];
		}

		//�쐬�����������Ԃ��B
		return new String(temp_byte);
	}

	//�ړI�o�C�g�����i�[����ϐ�
	private int byte_num;
	//�Ώۂ̕�������i�[����ϐ�
	private String byte_string;
	//���߂镶�����i�[����ϐ�
	private String spacer;
	//������ƖړI�o�C�g����؂�̂Ă̗L����ۊǂ���t���O
	private boolean byte_flag;

	//���߂镶�������p�łȂ��������́A�f�t�H���g����
	private final String DEFAULT_SPACER = " ";
}
