```
configMap will store the non sensitive data and secrets will store the sensitive data.
```

```
echo -n 'admin123' | base64
YWRtaW4xMjM=

echo -n 'testuser' | base64
dGVzdHVzZXI=

echo -n 'testuser@123' | base64
dGVzdHVzZXJAMTIz
```
