# Change Log

All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased][unreleased]

### Added

- Descriptions of each converter in README

### Fixed

- Wrong image link for disabled menu in README
- Typo in README
- Wrong link to the downloadable NBM file at Github

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
