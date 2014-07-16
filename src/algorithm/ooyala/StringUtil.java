package algorithm.ooyala;

public class StringUtil {
	
	static boolean hasDecimals(int pointIndex) {
		if (pointIndex == -1) {
			return false;
		}
		return true;
	}
	
	private static String abs(String value) {
		return Integer.toString(Math.abs(Integer.parseInt(value)));
	}
	
	private static void formatPrefix(StringBuilder builder, String value) {
		if (value.contains("-")) {
			builder.append("-$");
		} else {
			builder.append("$");
		}
	}
	
	private static String formatInteger(StringBuilder builder, String value) {
		int pointIndex = value.indexOf(".");
		String integer = null;
		if (!StringUtil.hasDecimals(pointIndex)) {
			integer = StringUtil.abs(value);
		} else {
			integer = StringUtil.abs(value.substring(0, pointIndex));
		}		
		StringBuilder newInteger = new StringBuilder();
		int countThousands = 0;
		for (int i = integer.length() - 1; i >=0; i--) {
			countThousands++;
			Character character = integer.charAt(i);
			newInteger.append(character);
			if (countThousands%3 == 0 && i != 0) {
				newInteger.append(",");
			}
		}
		return builder.append(newInteger.reverse()).toString();
	}
	
	private static void formatDecimal(StringBuilder builder, String value) {
		int pointIndex = value.indexOf(".");
		if (!StringUtil.hasDecimals(pointIndex)) {
			builder.append("00");
		} else {
			String decimal = value.substring(pointIndex + 1);
			if (decimal.length() > 2) {
				builder.append(decimal.substring(0,2));
			} else {
				StringBuilder newDecimal = new StringBuilder(decimal);
				while(newDecimal.length() < 2) {
					newDecimal.append("0");
				}
				builder.append(newDecimal);
			}
		}
	}
	
	public static String format(String value) {
		StringBuilder result = new StringBuilder();
		StringUtil.formatPrefix(result, value);
		StringUtil.formatInteger(result, value);
		result.append(".");
		StringUtil.formatDecimal(result, value);
		return result.toString();
	}
}