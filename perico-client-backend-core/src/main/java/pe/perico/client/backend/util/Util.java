package pe.perico.client.backend.util;

import pe.perico.client.backend.constants.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Util {

    private Util() {
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();

        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static LocalDateTime fromTimestamp(ResultSet rs, String column)
            throws SQLException {
        if (Objects.nonNull(column)) {
            Timestamp timestamp = rs.getTimestamp(column);
            return getDateTime(timestamp);
        } else {
            return null;
        }
    }

    public static LocalDateTime getDateTime(Timestamp timestamp) {
        return timestamp != null ? LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp.getTime()), ZoneId.of(Constants.ZONE_AMERICA)) : null;
    }
}
