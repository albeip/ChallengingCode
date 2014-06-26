package algorithm.ooyala;

public class StringUtil {
	
	public static String format(String value) {
		StringBuilder builder = null;
		if (value.contains("-")) {
			builder = new StringBuilder("-$");
		} else {
			builder = new StringBuilder("$");
		}
		int pointIndex = value.indexOf(".");
		String integer = null;
		StringBuilder decimal = new StringBuilder();
		if (pointIndex == -1) {
			integer = value;
			decimal.append("00");
		} else {
			integer = Integer.toString(Math.abs(Integer.parseInt(value.substring(0, pointIndex))));
			decimal.append(value.substring(pointIndex + 1));
			if (decimal.length() > 2) {
				decimal = new StringBuilder(decimal.substring(0,2));
			} else {
				while(decimal.length() < 2) {
					decimal.append("0");
				}
			}
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
		builder.append(newInteger.reverse()).append(".").append(decimal);
		return builder.toString();
	}
}