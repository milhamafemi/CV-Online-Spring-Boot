# CV-Online-Spring-Boot

dont forget to import database


export:
>exp namaWorspace/password full=y file=namafile.dmp log=namafile.log consistent=y

>full db/tablespaace == 2 = user / 3 = tables
>export grants y/n
>export table data y/n
>compress extents y/n
done

--file export path = C:\Windows\SysWOW64


import:
imp system/password fromuser= "workspaceAwal" touser="worspaceTujuan" file="fileExport".dmp commit=Y ignore=Y log=imp"fileLOGExport".log