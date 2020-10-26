principal = 5000
res = 0
each_payment = 5000/6
e = 0.023/365
for i in range(1,6):
    principal = principal - each_payment*i
    interest = principal*((1+e)**30) - principal
    principal = principal + interest
    res += interest

print(res)  