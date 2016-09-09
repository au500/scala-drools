#################
#
# Docker file for installing scala + Scala Drools application
#
#################

# docker build -t sbt-base .
# docker run --net="host" -i -t -p 8080 sbt-base
# docker run -i -t -p 127.0.0.1:8080:8080 --name scala1 sbt-base


FROM reynoldsm88/scala-sbt-launcher

RUN git clone https://github.com/reynoldsm88/scala-drools
ENV APP ./scala-drools

EXPOSE 8080

CMD cd $APP && ./run start