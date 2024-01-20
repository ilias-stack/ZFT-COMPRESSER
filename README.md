# ZFT-COMPRESSER
ZFT-COMPRESSER is a Java-based console application for compressing and decompressing folders using a custom .zft format. This project was made for FUN only and should not be adopted as a serious compressing solution hence it does not compress your folders rather than assembling all their contents inside a decompressable single .ztf file.

## Table of Contents
- [Features](#features)
- [Usage](#usage)
  - [Compression](#compression)
  - [Decompression](#decompression)

## Features
- Simple console application for compression and decompression.
- Password protection for compressed files.

## Usage
The easiest way is to download the executable file or JAR(if you already have java installed in your machine) and follow these easy steps.
```Then run the excutable file inside your terminal```

### For Compression
To compress a folder, here's this example:
```
Do you want to compress(to folder.zft) or decompress(from folder.zft) [C/D]? c

---You chose COMPRESSION---

Please enter the path of the folder to compress :path\to\YourFolder
->If you want to add a password type it : app
Password is app

FOLDER WAS COMPRESSED SUCCESSFULLY!
```
**NOTE**: You can leave the password field empty if you don't need to require a password for your file decompression.

### For Decompression
To decompress a file.zft, here's this example:
```
Do you want to compress(to folder.zft) or decompress(from folder.zft) [C/D]? d

---You chose DECOMPRESSION---

Please enter .zft file path :path\to\YourFolder.zft

-This file is protected with a password! Please type it before continuing :
app

FILE WAS DECOMPRESSED SUCCESSFULLY!
```

Some additional guidance:
1. It is generally more reliable if you use the **absolute path** rather than the relative.
2. The compression places the *file.zft* in the same location as the executable.
3. The decompression places the decopmressed folder in the same location as the *file.zft*.
