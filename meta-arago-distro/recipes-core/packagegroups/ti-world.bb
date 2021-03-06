SUMMARY = "TI World packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

INSANE_SKIP_${PN} += "dev-deps"

CHROMIUM = ""
CHROMIUM_append_omap-a15 = "\
    chromium-ozone-wayland \
"
CHROMIUM_append_k3 = "\
    chromium-ozone-wayland \
"

EXTRABROWSERS = " \
    qtwebbrowser-examples \
    qtwebengine-qmlplugins \
    qtwebengine-examples \
"

PYTHON2APPS = " \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu',"${EXTRABROWSERS}",'',d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', "${CHROMIUM}", '', d)} \
"

DEVTOOLS = " \
    linux-libc-headers-dev \
    build-essential \
    packagegroup-core-tools-debug \
    git \
"

OPENCL = " \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl ti-opencl','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl-extra','',d)} \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    ti-test \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-graphics','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-gtk','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-qte qt3d-examples','',d)} \
    ${@oe.utils.all_distro_features(d, "opencl", "${OPENCL}")} \
    packagegroup-arago-tisdk-connectivity \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-matrix \
    packagegroup-arago-tisdk-matrix-extra \
    packagegroup-arago-tisdk-multimedia \
    packagegroup-arago-tisdk-amsdk \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-tisdk-addons-extra \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-hmi','packagegroup-arago-base-tisdk-server-extra',d)} \
    ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "${PYTHON2APPS}", "", d)} \
    ${DEVTOOLS} \
    ${@bb.utils.contains('TUNE_FEATURES', 'armv7a', 'valgrind', '', d)} \
    packagegroup-arago-misc \
    ti-analytics \
    ti-demos \
    ${PREFERRED_PROVIDER_virtual/docker} \
"
