SUMMARY = "Debian's keys for apt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://debian-archive-bullseye-automatic.gpg \
			file://debian-archive-bullseye-security-automatic.gpg \
			file://debian-archive-bullseye-stable.gpg \
			file://debian-archive-buster-automatic.gpg \
			file://debian-archive-buster-security-automatic.gpg \
			file://debian-archive-buster-stable.gpg \
			file://debian-archive-stretch-automatic.gpg \
			file://debian-archive-stretch-security-automatic.gpg \
			file://debian-archive-stretch-stable.gpg \
			file://sources.list \
			"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/etc/apt/
    install -d ${D}/etc/apt/trusted.gpg.d/

	install -m 0777 ${S}/debian-archive-bullseye-automatic.gpg ${D}/etc/apt/trusted.gpg.d/
	install -m 0777 ${S}/debian-archive-bullseye-security-automatic.gpg ${D}/etc/apt/trusted.gpg.d/
	install -m 0777 ${S}/debian-archive-bullseye-stable.gpg ${D}/etc/apt/trusted.gpg.d/

	install -m 0777 ${S}/debian-archive-buster-automatic.gpg ${D}/etc/apt/trusted.gpg.d/
	install -m 0777 ${S}/debian-archive-buster-security-automatic.gpg ${D}/etc/apt/trusted.gpg.d/
	install -m 0777 ${S}/debian-archive-buster-stable.gpg ${D}/etc/apt/trusted.gpg.d/

	install -m 0777 ${S}/debian-archive-stretch-automatic.gpg ${D}/etc/apt/trusted.gpg.d/
	install -m 0777 ${S}/debian-archive-stretch-security-automatic.gpg ${D}/etc/apt/trusted.gpg.d/
	install -m 0777 ${S}/debian-archive-stretch-stable.gpg ${D}/etc/apt/trusted.gpg.d/

	install -m 0777 ${S}/sources.list ${D}/etc/apt/
}
