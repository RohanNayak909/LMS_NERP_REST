package nirmalya.aatithya.restmodule.lms.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateUtil {
  private static final Pattern VAR = Pattern.compile("\\{\\{\\s*([a-zA-Z0-9_\\.]+)\\s*\\}\\}");

  public static String render(String template, Map<String, ?> data) {
    if (template == null) return null;
    Matcher m = VAR.matcher(template);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
      String key = m.group(1);
      Object v = lookup(data, key);
      m.appendReplacement(sb, Matcher.quoteReplacement(v == null ? "" : String.valueOf(v)));
    }
    m.appendTail(sb);
    return sb.toString();
  }

  @SuppressWarnings("unchecked")
  private static Object lookup(Map<String, ?> data, String key) {
    if (data == null) return null;
    if (!key.contains(".")) return data.get(key);
    Object cur = data;
    for (String part : key.split("\\.")) {
      if (!(cur instanceof Map)) return null;
      cur = ((Map<String, Object>) cur).get(part);
      if (cur == null) return null;
    }
    return cur;
  }
}
