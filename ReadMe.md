# SVM
svm is a simple and straight forward menu cli application for printing upcoming meals at HSR applied university of Rapperswil mensa.


## Usage

```
$ java -jar svm help
Usage svm [options...]

Options
 mensa		Print menu of HSR Mensa
 bistro		Print menu of HSR Bistor
 vegi	vegetarian, v	Print vegetarian menus only

 tod	today	Print menu of this day
 tom	tomorrow	Print menu of tomorrow
 mo	mon, monday	Print monday's menu
 tu	tue, tuesday	Print tuesday's menu
 we	wed, wednesday	Print tuesday's menu
 th	thu, thursday	Print thursday's menu
 fr	fri, friday	Print friday's menu
 sa	sat, saturday	Print saturday's menu
 all		Print all upcoming menus

 help		Print this help message


```


## Examples

Print today menues
```
$ java -jar svm tod
=== Mi 04.12.
---
Schweins-Geschnetzeltes mit Pilzrahmsauce, Muschelteigwaren und Mischgemüse mit Kräutern
Herkunft: Schwein / Schweiz
INT 8.00 | EXT 12.00

---
Kartoffel- Gemüse Tortilla mit Salsa Dip und Frühlingszwiebeln Menusalat
Vegetarisch
INT 8.00 | EXT 12.00

---
Buffet -Blattspinat mit Peperoncini und Sesam -Blumenkohl Tandoori und weitere Beilagen
Kleiner Teller (Vegetarisch) INT 6.00 / EXT 9.00
INT 8.00 | EXT 12.00

---
Klassiker -Rindsburger -Bratwurst mit Zwiebelsauce -Paniertes Schnitzel -Pommes Frites
Herkunft: Rind / Schweiz, Kalb / Schweiz, Schwein / Schweiz
INT 8.00 | EXT 12.00


```