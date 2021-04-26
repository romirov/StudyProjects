# Use the official image as a parent image.
FROM debian:10.5

RUN apt-get update && apt-get install -y locales && rm -rf /var/lib/apt/lists/* \
    && localedef -i en_US -c -f UTF-8 -A /usr/share/locale/locale.alias en_US.UTF-8
ENV LANG en_US.utf8

RUN apt-get update && apt-get install -y php php-cgi php-curl vim vim-addon-manager vim-common vim-syntastic vim-tabular git openssh-server build-essential libvorbis-dev libpcap-dev libsnappy-dev libcurl4-openssl-dev libssh-dev librrd-dev liblzo2-dev liblzma-dev libglib2.0-dev libxml2-dev default-jdk default-jre jsvc 
