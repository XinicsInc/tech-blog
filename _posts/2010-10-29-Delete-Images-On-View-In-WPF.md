---
layout: post
title: 'WPF 화면에 보여지는 이미지 삭제하기'
author: 자이닉스 일이
date: 2010-10-29 17:06
---
WPF에서 이미지를 보여줄 때 Image 태그의 Source를 설정해서 보여주는 방식을 사용한다.

이때 로딩된 이미지 파일을 삭제하려고 하면, Exception이 발생한다.
이것은 이미지의 Source를 null로 설정하여도 동일하게 발생하는데 
이를 해결하기 위해서 이미지 Source의 Cache 옵션을 설정하여 해결할 수 있다.

```CSharp
string filepath = @"c:\test.jpg";
this.img.Source = new BitmapImage(new Uri(filepath, UriKind.RelativeOrAbsolute));
this.img.Source = null;
File.Delete(filepath);
```
<span style="color:red">**!!!Exception 발생**</span>

```CSharp
string filepath = @"c:\test.jpg";

BitmapImage bi = new BitmapImage();
bi.BeginInit();
bi.CacheOption = BitmapCacheOption.OnLoad;
bi.CreateOptions = BitmapCreateOptions.IgnoreImageCache;
bi.UriSource = new Uri(filepath);
bi.EndInit();
img.Source = bi;

File.Delete(filepath);
```
<span style="color:red">**정상적으로 파일이 삭제됨**</span>