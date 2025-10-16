output_dict = {}

even,odd,three = set(),set(),set()


for num in range(0,20):
    if num%2==0:
        even.add(num)
        
    if num%2==1:
        odd.add(num)
        
    if num%3==0 and num!=0:
        three.add(num)


output_dict['even'] = even
output_dict['odd'] = odd
output_dict['three'] = three


for elem in output_dict:
    print(elem ,": " , output_dict[elem])