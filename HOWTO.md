# Nexcomm meta layer for Trio

Tested with:
NXP imx BSP imx-5.10.72-2.2.2 (Yocto hardknott)

## Build instructions
1. install the “repo” utility, perform these steps:
Create a bin folder in the home directory. 
```
$ mkdir ~/bin (this step may not be needed if the bin folder already exists)
$ curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
$ chmod a+x ~/bin/repo
```

2. Add the following line to the .bashrc file to ensure that the ~/bin folder is in your PATH variable.
```
$ export PATH=~/bin:$PATH
```

3. Create a build directory and download the upstream sources
```
$ mkdir ~/imx-yocto-bsp-5.10.72_2.2.2
$ cd ~/imx-yocto-bsp-5.10.72_2.2.2
$ repo init -u https://github.com/nxp-imx/imx-manifest -b imx-linux-hardknott -m imx-5.10.72-2.2.2.xml
$ repo sync
```

4. Goto the _sources_ directory and clone this repo (setup ssh deploy keys in your bitbucket account first)
```
$ cd ~/imx-yocto-bsp-5.10.72_2.2.2/sources
$ git clone git@bitbucket.org:trio-bsp/meta-nexcomm.git
```

5. Download additional layers:
`$ git clone --branch hardknott git://git.yoctoproject.org/meta-selinux`
`$ git clone clone git://git.yoctoproject.org/meta-munters` FIX!!

6. Setup the build environment
```
$ cd ~/imx-yocto-bsp-5.10.72_2.2.2
$ DISTRO=fsl-imx-xwayland MACHINE=imx8mm-lpddr4-trio source sources/meta-nexcomm/tools/nexcomm-setup-env.sh -b build-xwayland
```

7. Add layers to project (order matters):
`echo 'BBLAYERS += "${BSPDIR}/sources/meta-selinux"' >> ./conf/bblayers.conf`
`echo 'BBLAYERS += "${BSPDIR}/sources/meta-munters"' >> ./conf/bblayers.conf`

8. Build image
```
$ bitbake imx-image-multimedia
```

// Manual. Not required
9. Deploy image on device and update configuration of apt util:
copy `.../apt/trusted.gpg.d/` and `.../apt/sources.list` to `/etc/apt/` on device

