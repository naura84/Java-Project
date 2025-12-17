package services;

public class ScheduleUtils {

    /**
     * Very small parser to extract the first timeslot from a schedule JSON string.
     * Expected format: [{"day":"Tue","start":"13:00","end":"15:30"}, ...]
     * Returns a human-friendly string like "Tue 13:00 - 15:30" or the original string on parse failure.
     */
    public static String parseScheduleToTime(String scheduleJson) {
        if (scheduleJson == null) return "";
        try {
            String s = scheduleJson.trim();
            // find day
            String day = extractValue(s, "day");
            String start = extractValue(s, "start");
            String end = extractValue(s, "end");
            StringBuilder out = new StringBuilder();
            if (day != null && !day.isEmpty()) out.append(day);
            if (start != null && !start.isEmpty()) {
                if (out.length() > 0) out.append(' ');
                out.append(start);
            }
            if (end != null && !end.isEmpty()) {
                out.append(" - ").append(end);
            }
            String res = out.toString();
            return res.isEmpty() ? scheduleJson : res;
        } catch (Exception ex) {
            return scheduleJson;
        }
    }

    private static String extractValue(String s, String key) {
        String pattern1 = "\"" + key + "\"\s*:\s*\""; // "key":"
        int idx = s.indexOf(pattern1);
        if (idx < 0) return null;
        int start = idx + pattern1.length();
        int end = s.indexOf('"', start);
        if (end < 0) return null;
        return s.substring(start, end);
    }
}
