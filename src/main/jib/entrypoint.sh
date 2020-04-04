#!/bin/sh

echo "The application will start in ${WEB_APP_SLEEP}s..." && sleep ${WEB_APP_SLEEP}
exec java ${JAVA_OPTS} -noverify -XX:+AlwaysPreTouch -cp /app/resources/:/app/classes/:/app/libs/* "com.zaravya.sample.SampleApplication"  "$@"
