# Change Log

All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased][unreleased]

### Fixed

- Fix issue #2: get rid of `java.lang.String.stripLeading` to get backward compatibility with JDK 1.8

## 0.2.2 - 2020-09-29

### Fixed

- Fix issue #1: set Java minimal version to JDK 11

## 0.2.1 - 2020-09-29

### Fixed

- Fix background compatibility to NetBeans version 11.0+

## 0.2.0 - 2020-09-29

### Changed

- Update enabled menu screenshot
- Change builder from Ant to Maven
- Update README
- Set NetBeans API version compatibility to 12.1

### Fixed

- Fix module description

## 0.1.1 - 2019-05-24

### Changed

- Swap _Status_ and _Installation_ sections in README
- Change module display category to `Editing` instead of `Tools`
- Enhance the module description with HTML to make it more readable

### Added

- Descriptions of each converter in README
- Add `StringUtils.uncapitalizeFirstChar()` method
- Add ToPascalCaseConverter converter
- Add ConvertToPascalCaseAction action

### Fixed

- Wrong image link for disabled menu in README
- Typo in README
- Wrong link to the downloadable NBM file at Github
- Fix camelCase by uncapitalizing the first character

## 0.1.0 - 2019-05-23

### Added

- package files
- Actions:
  - ConvertToPopupAction
  - ConvertToAction abstract class
  - ConvertToCamelCaseAction
  - ConvertToHyphenCaseAction
  - ConvertToLowerCaseAction
  - ConvertToSentenceCaseAction
  - ConvertToSnakeCaseAction
  - ConvertToTitleCaseAction
  - ConvertToUpperCaseAction
- Converters:
  - Converter interface
  - ConverterFactory abstract class
  - ToCamelCaseConverter
  - ToHyphenCaseConverter
  - ToLowerCaseConverter
  - ToSentenceCaseConverter
  - ToSnakeCaseConverter
  - ToTitleCaseConverter
  - ToUpperCaseConverter
- Utils:
  - StringUtils
