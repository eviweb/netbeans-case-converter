NetBeans Case Converter
=======================

This module provides easy to use string case converters.

Status
------

[![GitHub license][license-badge]][license-link]
[![GitHub release][release-badge]][release-latest]

Compatibility
-------------

* NetBeans version 11.0+
* Java version 1.8+

Installation
------------

### Manually

First, download the latest [_NBM_][nbm] package.  
Then proceed through the menu _Tools > Plugins > Downloaded > Add Plugins..._

### Apache NetBeans Plugin Portal Update Center

Go to _Tools > Plugins > Available Plugins_, check _NetBeans Case Converter_ in the _Editing_ section, then click the _Install_ button.

Usage
-----

In the editor panel:

1. Select the text you want to change the case of
2. Right-click to open the contextual menu
3. Open the `Convert To...` submenu
4. Click on the converter of your choice

![Convert To... enabled](/resources/enabled-menu.png)

Please note that if no text is selected, the menu is disabled.

![Convert To... disabled](/resources/disabled-menu.png)

Available Converters
--------------------

Current available converters:

- `camelCase`: _first capitalized letter of each word, except for the first letter of the resulting word, no space_
- `hyphen-case`: _lower case words separated with an hyphen_
- `lower case`: _lower case words_
- `PascalCase`: _first capitalized letter of each word, no space_
- `Sentence case.`: _first capitalized letter of the first word, ends with a dot (capital letters within the sentence are preserved)_
- `snake_case`: _lower case words separated with an underline character_
- `Title Case`: _first capitalized letter of each word, one space between words_
- `UPPER CASE`: _upper case words_

License
-------

This project is licensed under the terms of the [Apache License, version 2](/LICENSE)

[nbm]: https://github.com/eviweb/netbeans-case-converter/releases/latest/download/fr-evidev-netbeans-caseconverter.nbm
[license-badge]: https://img.shields.io/github/license/eviweb/netbeans-case-converter.svg
[license-link]: https://github.com/eviweb/netbeans-case-converter/blob/master/LICENSE
[release-badge]: https://img.shields.io/github/release/eviweb/netbeans-case-converter.svg
[release-latest]: https://github.com/eviweb/netbeans-case-converter/releases/
