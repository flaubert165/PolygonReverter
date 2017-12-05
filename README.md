# PolygonReverter

PolygonReverterApp is a Java app that reverts geo-polygon formats from (lat, long) to (long, lat) or (long, lat) to (lat, long) after read of the data from a text file.

HOW TO USE:

1 - "Copy" the polygon to the file "polygon.txt"* (found inside the source folder) and "Save" file;

2 - Start the application;

*(copy the polygon without "POLYGON(())", just the coordinates).

Example:

Polygon to revert:

-46.758021799291335 -23.55097828141881, -46.75872274036694 -23.549324261022917, -46.758751756082724 -23.549016255059684, -46.75916677442201

Reverted Polygon:

POLYGON ((- 23.55097828141881 -46.758021799291335, -23.549324261022917 -46.75872274036694, -23.549016255059684 -46.758751756082724))
