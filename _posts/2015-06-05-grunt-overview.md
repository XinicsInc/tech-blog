---
layout: post
title: 'Javascript Task Runner : Grunt 의 개요 및 장점'
author: xinics
date: 2015-06-05 18:07
tags: [javascript, grunt]
---

기존에 Xinics에서는 HTML5 Javascript 어플리케이션 배포를 위해 빌드 시 Ant 스크립트를 사용해 왔었습니다. Ant 스크립트로 Javascript 빌드를 할 때의 여러 가지 한계와 불편한 점으로 인해 대안을 조사하였습니다. 그 일환으로 Grunt에 대해 조사한 내용을 공유합니다.

## 1. Grunt란? 

![Grunt](/files/files/2015/06/05/grunt.png)

Grunt는 Javascript를 사용한 Task Runner입니다. 즉 반복적인 작업을 스크립트를 통해서 한 번에 수행하게 해주는 자동화 도구입니다. Javascript 앱 빌드의 경우에는 여러 가지 JS 및 CSS 파일을 하나로 합치고 minify 하며 또 어떤 파일은 배포 폴더로 복사하고 하는 과정들을 스크립트를 작성하여 한 줄의 명령어를 통해 자동화시킬 수 있습니다. Makefile, Ant 등의 Javascript 버전이라고 볼 수 있습니다. Grunt와 Grunt 플러그인들은 npm(Node.js Package Manager)을 통해 설치되고 관리됩니다. 즉 Node.js 모듈입니다. 자세한 내용은 [공식 웹사이트](http://gruntjs.com/)에서 확인하실 수 있습니다.


## 2. Grunt의 장점

### 1. Javascript/Node.js 기반의 빌드 툴이다.

Javascript 및 Node.js는 활발하게 유지 보수되며 성장하고 있는 언어 및 플랫폼입니다. 따라서 안정성 및 전망에서 많은 기대를 할 수 있습니다. 

### 2. Javascript 어플리케이션에서 사용되는 다양한 기능들을 안정적인 플러그인으로 제공한다.

jshint, minify, uglify, less 등 Javascript 어플리케이션에서 주로 사용되는 대부분 기능을 플러그인으로 제공하고 있습니다. 또한, Ant보다 안정적입니다. 플러그인의 안정성과 관련하여 Xinics에서 Ant를 사용하는 동안은 몇 가지 문제점이 있었습니다. Ant 스크립트에서 Javascript minify를 위해 사용하는 Yui Compressor 최신 버전( 2.4.8 )은 [Window 환경에서 PATH 문제로 인해 기본 동작을 하지 않는 이슈](https://github.com/yui/yuicompressor/issues/78)가 있었습니다.또한 Ant 스크립트에서 jshint를 지원하는 라이브러리 [ant-jshint](https://github.com/philmander/ant-jshint) 는 더이상 진행되고 있지 않습니다(!)

### 3. 작성 및 유지보수가 쉬운 빌드 스크립트를 제공한다.

간단하고 직관적인 설정 및 빌드 스크립트를 제공합니다. 또한, Javascript 언어 기반으로 되어 있기에 만약 플러그인이 지원하지 않는 기능에 대해서는 직접 소스코드를 통해서 구현할 수 있다는 유연성도 가지고 있습니다. Ant 등의 다른 빌드 툴에 비해 어느 정도 간결한지는 아래 나타나 있습니다.


![Grunt](/files/files/2015/06/05/compare_build_script.png)

출처 : [Whe We Use Node.js and Grunt to Build Javascript](http://mechanics.flite.com/blog/2012/06/19/why-we-use-node-dot-js-and-grunt-to-build-javascript/)

### 4. 커뮤니티가 크고 활발하다.

Grunt 외에도 Node.js 기반으로 빌드하는 방식은 Gulp를 사용하는 방식과 npm 스크립트를 사용하는 방식이 있습니다. 앞서 거론한 장점들은 이 방식들도 가지고 있습니다. 그래서 Grunt, Gulp, npm 스크립트 중 어떤 것이 좋은지에 대해 다양한 의견이 있습니다. 자세한 내용은 아래 포스트들에서 살펴보실 수 있습니다.

[The Battle of Build Scripts: Gulp vs Grunt](http://www.hongkiat.com/blog/gulp-vs-grunt/)
[Why We should stop using Grunt & Gulp](Why We should stop using Grunt & Gulp)

그러나 Grunt가 확실히 장점을 가지는 부분은 가장 커뮤니티가 넓고 활발하다는 점입니다. 다양한 플러그인들이 개발되었고 많은 사용자층이 있으며 유지보수 및 업데이트가 잘 진행되고 있습니다. 또한, jQuery, Wordpress, Twitter 등 유명 라이브러리 및 플랫폼에서 빌드를 위해 Grunt를 사용한다는 것 또한 신뢰를 주는 부분입니다.

P.S 한국어 페이스북 커뮤니티도 있습니다! [https://www.facebook.com/groups/gruntjs.kr/](https://www.facebook.com/groups/gruntjs.kr/)