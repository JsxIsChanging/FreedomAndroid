package com.example.a91256.freedomandroid.utils;

import java.util.List;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

public class NetworkState {
	private static NetworkState networkUtils;
	private static Context mContext;

	// SIM卡状态常量
	private static final String SIM_ABSENT = "Absent"; // 手机内无SIM卡
	private static final String SIM_READY = "Ready"; // SIM卡已准备好
	private static final String SIM_PIN_REQUIRED = "PIN required"; // 需要SIM卡的PIN解锁
	private static final String SIM_PUK_REQUIRED = "PUK required"; // 需要SIM卡的PUK解锁
	private static final String SIM_NETWORK_LOCKED = "Network locked"; // 需要Network
																		// PIN解锁
	private static final String SIM_UNKNOWN = "Unknown"; // 状态未知

	// 网络类型常量
	private static final String NETWORK_CDMA = "CDMA: Either IS95A or IS95B (2G)";
	private static final String NETWORK_EDGE = "EDGE (2.75G)";
	private static final String NETWORK_GPRS = "GPRS (2.5G)";
	private static final String NETWORK_UMTS = "UMTS (3G)";
	private static final String NETWORK_EVDO_0 = "EVDO revision 0 (3G)";
	private static final String NETWORK_EVDO_A = "EVDO revision A (3G - Transitional)";
	private static final String NETWORK_EVDO_B = "EVDO revision B (3G - Transitional)";
	private static final String NETWORK_1X_RTT = "1xRTT  (2G - Transitional)";
	private static final String NETWORK_HSDPA = "HSDPA (3G - Transitional)";
	private static final String NETWORK_HSUPA = "HSUPA (3G - Transitional)";
	private static final String NETWORK_HSPA = "HSPA (3G - Transitional)";
	private static final String NETWORK_IDEN = "iDen (2G)";
	private static final String NETWORK_UNKOWN = "Unknown";

	// 手机制式类型常量
	private static final String PHONE_CDMA = "CDMA";
	private static final String PHONE_GSM = "GSM";
	private static final String PHONE_NONE = "No radio";

	// 运营商类型
	private static final int CHINA_UNKNOWN = -1;
	private static final int CHINA_MOBILE = 100;
	private static final int CHINA_UNICOM = 101;
	private static final int CHINA_TELECOM = 102;

	// 各信息类型

	private  TelephonyManager mTelephonyManager;
	private  int mCallSate;
	private  CellLocation mCellLocation;
	private  int mDateActivity;
	private  int mDataState;
	private  String mDeviceId;
	private  String mDeviceSoftwareVersion;
	private  String mLineNumber;
	private  List<NeighboringCellInfo> mNeighboringCellInfo;
	private  String mNetworkCountryIso;
	private  String mNetworkOperator;
	private  String mNetworkOperatorName;
	private  int mNetworkType;
	private  int mPhoneType;
	private  String mSimCountryIso;
	private  String mSimOperator;
	private  String mSimOperatorName;
	private  String mSimSerialNumber;
	private int mSimState;
	private String mSubscriberId;
	private String mVoiceMailAlphaTag;
	private String mVliceMailNumber;
	private boolean hasIccCard;
	private boolean isNetworkRoaming;

	public synchronized static NetworkState getInstance(Context context) {
		mContext = context;
		if (networkUtils == null) {
			networkUtils = new NetworkState();
		}
		return networkUtils;
	}

	public TelephonyManager getTelephonyManager() {
		// 获取telephony系统服务，用于取得SIM卡和网络相关信息
		if (mTelephonyManager == null) {
			mTelephonyManager = (TelephonyManager) mContext
					.getSystemService(Context.TELEPHONY_SERVICE);
		}
		return mTelephonyManager;
	}

	/**
	 * 电话状态： 1.tm.CALL_STATE_IDLE=0 无活动 2.tm.CALL_STATE_RINGING=1 响铃
	 * 3.tm.CALL_STATE_OFFHOOK=2 摘机
	 */
	public int getCallState(Context context) {
		mCallSate = getTelephonyManager().getCallState();// int
		return mCallSate;
	}

	/**
	 * 电话方位： 返回当前移动终端的位置
	 */
	public CellLocation getCellLocation() {
		mCellLocation = getTelephonyManager().getCellLocation();// CellLocation
		return mCellLocation;
	}

	/**
	 * 请求位置更新，如果更新将产生广播， 接收对象为注册LISTEN_CELL_LOCATION的对象，
	 * 需要的permission名称为ACCESS_COARSE_LOCATION。
	 */
	public void updateCellLocation(Context context) {
		mCellLocation = getTelephonyManager().getCellLocation();// CellLocation
		mCellLocation.requestLocationUpdate();
	}

	/**
	 * 获取数据活动状态
	 * 
	 * DATA_ACTIVITY_IN 数据连接状态：活动，正在接受数据 DATA_ACTIVITY_OUT 数据连接状态：活动，正在发送数据
	 * DATA_ACTIVITY_INOUT 数据连接状态：活动，正在接受和发送数据 DATA_ACTIVITY_NONE
	 * 数据连接状态：活动，但无数据发送和接受
	 */
	public int getDateActivity() {
		mDateActivity = getTelephonyManager().getDataActivity();
		return mDateActivity;
	}

	/**
	 * 获取数据连接状态
	 * 
	 * DATA_CONNECTED 数据连接状态：已连接 DATA_CONNECTING 数据连接状态：正在连接 DATA_DISCONNECTED
	 * 数据连接状态：断开 DATA_SUSPENDED 数据连接状态：暂停
	 */
	public int getDataState() {
		mDataState = getTelephonyManager().getDataState();
		return mDataState;
				
	}

	/**
	 * 唯一的设备ID： GSM手机的 IMEI 和 CDMA手机的 MEID. Return null if device ID is not
	 * available.
	 */
	public String getDeviceId() {
		mDeviceId = getTelephonyManager().getDeviceId();// String
		return mDeviceId;
	}

	/**
	 * 设备的软件版本号： 返回移动终端的软件版本，例如：GSM手机的IMEI/SV码。 例如：the IMEI/SV(software version)
	 * for GSM phones. Return null if the software version is not available.
	 */
	public String getDeviceSoftwareVersion() {
		mDeviceSoftwareVersion = getTelephonyManager().getDeviceSoftwareVersion();// String
		return mDeviceSoftwareVersion;
	}

	/**
	 * 手机号： 返回手机号码，对于GSM网络来说即MSISDN GSM手机的 MSISDN. Return null if it is
	 * unavailable.
	 */
	public String getLineNumber() {
		mLineNumber = getTelephonyManager().getLine1Number();// String
		return mLineNumber;
	}

	/**
	 * 附近的电话的信息: 返回当前移动终端附近移动终端的信息 类型：List<NeighboringCellInfo>
	 * 需要权限：android.Manifest.permission#ACCESS_COARSE_UPDATES
	 */
	public List<NeighboringCellInfo> getNeighboringCellInfo() {
		mNeighboringCellInfo = getTelephonyManager().getNeighboringCellInfo();// List<NeighboringCellInfo>
		return mNeighboringCellInfo;
	}

	public void getNeighboringCellDetailInfo() {
		List<NeighboringCellInfo> infos = getTelephonyManager().getNeighboringCellInfo();
		
		for (NeighboringCellInfo info : infos) {
			StringBuffer sInfo = new StringBuffer();
			// 获取邻居小区号
			int cid = info.getCid();
			// 获取邻居小区LAC，LAC:
			// 位置区域码。为了确定移动台的位置，每个GSM/PLMN的覆盖区都被划分成许多位置区，LAC则用于标识不同的位置区。
			int lac = info.getLac();
			int nettype = info.getNetworkType();
			int psc = info.getPsc();
			// 获取邻居小区信号强度
			int rssi = info.getRssi();
  		    Log.d("NeighboringCellInfo","--Cid:"+cid+",Lac:"+lac+",NetworkType:"+nettype+",Psc:"+psc+",Rssi:"+rssi);
		}
	}

	/**
	 * 获取ISO标准的国家码，即国际长途区号。 注意：仅当用户已在网络注册后有效。 在CDMA网络中结果也许不可靠。
	 */
	public String getNetworkCountryIso() {
		mNetworkCountryIso = getTelephonyManager().getNetworkCountryIso();// String
		return mNetworkCountryIso;
	}

	/**
	 * MCC+MNC(mobile country code + mobile network code) 返回MCC+MNC代码
	 * (SIM卡运营商国家代码和运营商网络代码)(IMSI) 注意：仅当用户已在网络注册时有效。 在CDMA网络中结果也许不可靠。
	 */
	public String getNetworkOperator() {
		mNetworkOperator = getTelephonyManager().getNetworkOperator();// String
		return mNetworkOperator;
	}

	/**
	 * 返回移动网络运营商的名字(SPN) 按照字母次序的current registered operator(当前已注册的用户)的名字
	 * 注意：仅当用户已在网络注册时有效。 在CDMA网络中结果也许不可靠。
	 */
	public String getNetworkOperatorName() {
		mNetworkOperatorName = getTelephonyManager().getNetworkOperatorName();// String
		return mNetworkOperatorName;
	}

	/**
	 * 当前使用的网络类型： 例如： NETWORK_TYPE_UNKNOWN 网络类型未知 0 NETWORK_TYPE_GPRS GPRS网络 1
	 * NETWORK_TYPE_EDGE EDGE网络 2 NETWORK_TYPE_UMTS UMTS网络 3 NETWORK_TYPE_HSDPA
	 * HSDPA网络 8 NETWORK_TYPE_HSUPA HSUPA网络 9 NETWORK_TYPE_HSPA HSPA网络 10
	 * NETWORK_TYPE_CDMA CDMA网络,IS95A 或 IS95B. 4 NETWORK_TYPE_EVDO_0 EVDO网络,
	 * revision 0. 5 NETWORK_TYPE_EVDO_A EVDO网络, revision A. 6
	 * NETWORK_TYPE_1xRTT 1xRTT网络 7
	 * 
	 * 在中国，联通的3G为UMTS或HSDPA， 移动和联通的2G为GPRS或EGDE， 电信的2G为CDMA，电信的3G为EVDO
	 */
	public int getNetworkType() {
		mNetworkType = getTelephonyManager().getNetworkType();// int
		return mNetworkType;
	}

	/**
	 * 返回移动终端的类型 手机类型： 例如： PHONE_TYPE_NONE 无信号 ,手机制式未知 PHONE_TYPE_GSM GSM信号
	 * ,手机制式为GSM，移动和联通 PHONE_TYPE_CDMA CDMA信号 ,手机制式为CDMA，电信
	 */
	public int getPhoneType() {
		mPhoneType = getTelephonyManager().getPhoneType();// int
		return mPhoneType;
	}

	/**
	 * 返回SIM卡提供商的国家代码 Returns the ISO country code equivalent for the SIM
	 * provider's country code. 获取ISO国家码，相当于提供SIM卡的国家码。
	 * 
	 */
	public String getSimCountryIso() {
		mSimCountryIso = getTelephonyManager().getSimCountryIso();// String
		return mSimCountryIso;
	}

	/**
	 * 返回MCC+MNC代码 (SIM卡运营商国家代码和运营商网络代码)(IMSI) Returns the MCC+MNC (mobile
	 * country code + mobile network code) of the provider of the SIM. 5 or 6
	 * decimal digits. 获取SIM卡提供的移动国家码和移动网络码.5或6位的十进制数字. SIM卡的状态必须是
	 * SIM_STATE_READY(使用getSimState()判断).
	 */
	public String getSimOperator() {
		mSimOperator = getTelephonyManager().getSimOperator();// String
		return mSimOperator;
	}

	/**
	 * 服务商名称： 例如：中国移动、联通 SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断).
	 */
	public String getSimOperatorName() {
		mSimOperatorName = getTelephonyManager().getSimOperatorName();// String
		return mSimOperatorName;
	}

	/**
	 * 返回SIM卡的序列号(IMEI) SIM卡的序列号： 需要权限：READ_PHONE_STATE
	 */
	public String getSimSerialNumber() {
		mSimSerialNumber = getTelephonyManager().getSimSerialNumber();// String
		return mSimSerialNumber;
	}

	/**
	 * SIM的状态信息： SIM_STATE_UNKNOWN 未知状态 0 SIM_STATE_ABSENT 没插卡 1
	 * SIM_STATE_PIN_REQUIRED 锁定状态，需要用户的PIN码解锁 2 SIM_STATE_PUK_REQUIRED
	 * 锁定状态，需要用户的PUK码解锁 3 SIM_STATE_NETWORK_LOCKED 锁定状态，需要网络的PIN码解锁 4
	 * SIM_STATE_READY 就绪状态 5
	 */
	public int getSimState() {
		mSimState = getTelephonyManager().getSimState();// int
		return mSimState;
	}

	/**
	 * 返回用户唯一标识，比如GSM网络的IMSI编号 唯一的用户ID： 例如：IMSI(国际移动用户识别码) for a GSM phone.
	 * 需要权限：READ_PHONE_STATE
	 */
	public String getSubscriberId() {
		mSubscriberId = getTelephonyManager().getSubscriberId();// String
		return mSubscriberId;
	}

	/**
	 * 获取语音信箱号码关联的字母标识。 取得和语音邮件相关的标签，即为识别符 需要权限：READ_PHONE_STATE
	 */
	public String getVoiceMailAlphaTag() {
		mVoiceMailAlphaTag = getTelephonyManager().getVoiceMailAlphaTag();// String
		return mVoiceMailAlphaTag;
	}

	/**
	 * 返回语音邮件号码 获取语音邮件号码： 需要权限：READ_PHONE_STATE
	 */
	public String getVliceMailNumber() {
		mVliceMailNumber = getTelephonyManager().getVoiceMailNumber();// String
		return mVliceMailNumber;
	}

	/**
	 * ICC卡是否存在
	 */
	public boolean hasIccCard() {
		hasIccCard = getTelephonyManager().hasIccCard();// boolean
		return hasIccCard;
	}

	/**
	 * 是否漫游: (在GSM用途下)
	 */
	public boolean isNetworkRoaming() {
		isNetworkRoaming = getTelephonyManager().isNetworkRoaming();//
		return isNetworkRoaming;
	}
}
