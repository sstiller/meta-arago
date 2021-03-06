# Special "bleeding" branding for experimenting and testing unreleased components

require branding-core.inc

# Auto rev important packages to pick up latest
SRCREV_pn-linux-ti-staging = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-rt = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-systest = "${AUTOREV}"
SRCREV_pn-u-boot-ti-staging = "${AUTOREV}"
SRCREV_pn-u-boot-k3-r5 = "${AUTOREV}"
SRCREV_pn-ltp-ddt = "${AUTOREV}"
SRCREV_pn-optee-os = "${AUTOREV}"
#SRCREV_pn-optee-client = "${AUTOREV}"
#SRCREV_pn-optee-test = "${AUTOREV}"
SRCREV_pn-arm-trusted-firmware = "${AUTOREV}"

# Build and assemble TI-SDK, but don't package it
IMAGE_FSTYPES_pn-tisdk-core-bundle = ""
