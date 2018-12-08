package com.epam._old.encoder;

public class RunEncoderProgram {
    public static void main(String[] args) {
        FileEncryptor encryptor = new FileEncryptor("SECRET");
        try {
            if (encryptor.encodeAndSave("C:\\test\\text.txt", "C:\\test\\encode_text.txt")) {
                encryptor.decodeAndSave("C:\\test\\encode_text.txt", "C:\\test\\decode_text.txt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/* Version1

**** text.txt *****
The research director
had the department do a
thorough job in testing
the new product

**** encode_text.txt *****
llgiilwettlwavgtxhj
zefklxvirrvmeipkhhs
llqisnyllffbfxgjxbfk
llgeiphvquyvl

**** decode_text.txt *****
theresearchdirector
hadthedepartmentdoa
thoroughjobintesting
thenewproduct


* Version2

**** text.txt *****
The research director
had the department do a
thorough job in testing
the new product.

**** encode_text.txt *****
String must contain only latin characters

*/