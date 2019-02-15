package firsttoten;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;
public class criterion1 {
	public double weight=0;			//权重返回值
	public double Xzhen[];			// x向震动信号				传入入参数
	public double Yzhen[];			// y向震动信号
	public double JianXiang[];			// 键相信号
	public int ChuFa[];			// 记录阈值触发时间间隔			中间变量
	public int j;
	public double rpm;			// 转速
	public int NCaiYang;		// 采样点数
	double XzhenFFT[] = null;
	double tongpinX;			
	double Xfu1;
	double TtimeXiu[];
	int onecycletime;
	int Xxiang1;
	int bearnum;				//轴承个数						配置文件变量
	int JianHZ;					//键相信号采样频率
	int JianCF;					//键相信号触发阈值
	int ZhenHZ;					//振动信号采样频率
	double rpmlin1;				//一阶临界转速
	double rpmlin2;				//二阶临界转速
	boolean rotorgo;			//转子额定旋转方向
	boolean Xbx;                 //true时域波形接近正弦波		判断变量
	boolean usego;				//顺时针为真，逆时针为假
	int  shape;					//0,1,2,3,4分别代表椭圆型、8字型、香蕉型，双环椭圆型，杂乱型；

	public criterion1(double d[],int i[],boolean b[]){//步骤一:数据准备
		//通过构造函数来实现数据的准备
	}
	public void setChuFa() { 						// 步骤二:获取触发数组
		int j = 0;
		int opt = 0;
		for (int i = 0; i < JianHZ; i++)
		{
			if (opt == 0) {
				if (JianXiang[i] > JianCF) {
					ChuFa[j] = i; 		
					j++;//
					opt = 1;
				}
			} else {
				if (JianXiang[i] < JianCF - 50) 	
				{
					opt = 0;
				} 									
			}
		}
													
	}

	public void setRpm() { 							// 步骤3：根据之前触发的次数及触发的频率计算转速rpm
		if (j == 0 || j == 1)						
		{
			rpm = 0;
		} else {									// 取平均值
			int onecycletime = (ChuFa[j - 1] - ChuFa[0]) / JianHZ / (j - 1);
			rpm = 60.0 / onecycletime;
		}
	}

	public void setNCaiYang() {							//步骤4：设计应取得采样点数NCaiYang
		int ZongPoint = (ChuFa[j - 1] - ChuFa[0]) / JianHZ * ZhenHZ - 20;
		if (ZongPoint > 1024) {
			NCaiYang = 1024;
		} else if (ZongPoint > 512) {
			NCaiYang = 512;
		} else if (ZongPoint > 256) {
			NCaiYang = 256;
		} else {
			NCaiYang = 128;
		}
	}

	public void jqxz() {							//步骤5：对采样进行加权修正
		setNCaiYang();
		double XzhenMax = Xzhen[0];
		double XzhenMin = Xzhen[0];
		int i;
		for (i = 0; i < NCaiYang; i++) {
			int k = ChuFa[0];
			double time = k / JianHZ;
			long point = Math.round(time * ZhenHZ);
			if (XzhenMax < Xzhen[(int) (point + i)]) {
				XzhenMax = Xzhen[(int) (point + i)];
			}
			if (XzhenMin > Xzhen[(int) (point + i)]) {
				XzhenMin = Xzhen[(int) (point + i)];
			}
		}
		tongpinX = XzhenMax - XzhenMin;				
		for (i = 0; i < NCaiYang; i++) {
			int k = ChuFa[0];
			double time = k / JianHZ;
			long point = Math.round(time * ZhenHZ);
			XzhenFFT[i] = 2 * (Xzhen[(int) (point + i)] - (XzhenMax + XzhenMin) / 2)
					* Math.pow(Math.sin(i * 3.14 / (NCaiYang - 1)), 2);
		}
	}
	public void FFT() {							//步骤6：对采集的数据进行FFT变换
		FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
		Complex[] result = fft.transform(XzhenFFT, TransformType.FORWARD);
	}

	public void fzxw()							//步骤7：得到各频率下的幅值、相位
	{
		
	}
	public void ybfz()							//步骤8：工频为主为真；
	{
		
	}

	public void setXbx() // 步骤9：计算采样点时域波形
	{
		int i;
		double XzhenXiu[] = null;
		for (i = 0; i < NCaiYang; i++) {
			int k = ChuFa[0];
			double time = k / JianHZ;
			long point = Math.round(time * ZhenHZ);
			XzhenXiu[i] = 2 * (Xzhen[(int) (point + i)] - tongpinX / 2);
			int TtimeXiu = i / ZhenHZ;
		}
		double SumXzhenXiu = 0;
		int SumBiaosin = 0;
		double Biaosin[] = null;
		for (i = 0; i < NCaiYang; i++) {
			SumXzhenXiu = SumXzhenXiu + XzhenXiu[i];
			Biaosin[i] = Xfu1 * Math.sin(TtimeXiu[i] * 2 * 3.14 / onecycletime + Xxiang1);
			SumBiaosin = (int) (SumBiaosin + Biaosin[i]);
		}
		if ((SumXzhenXiu > 0.8 * SumBiaosin) && (SumXzhenXiu < 1.2 * SumBiaosin)) {
			Xbx = true;
			weight+=0.25;
		} else {
			Xbx = false;
		}
	}
	public void zztb()							//步骤10：判断转速稳定下幅值及相位的变化情况，若偏差小于定值为真
	{
		
	}
	public void ljjd()							//步骤11：过临界时振动大于限值为真
	{
		if(((rpm>rpmlin1-100)&&(rpm<rpmlin1+100))||((rpm>rpmlin2-100)&&(rpm<rpmlin2+100)))
		{
			if(tongpinX>100)
			{
				weight+=0.1;
			}
		}
	}
	public void zxgj()							//步骤12：做轴心轨迹图
	{
		if(shape==0)
		{
			weight+=0.1;
		}
		if(usego==rotorgo)
		{
			weight+=0.1;
		}
	}
	public int Go()
	{
		setChuFa();
		setRpm();
		setNCaiYang();
		jqxz();
		FFT();
		fzxw();
		ybfz();
		setXbx();
		zztb();
		ljjd();
		zxgj();
		return Check();
	}
	public int Check()
	{
		int flag=0;
		if(weight>0.8)
		{
			flag=2;
		}
		else if(weight>0.6)
		{
			flag=1;
		}
		return flag;
	}
}
