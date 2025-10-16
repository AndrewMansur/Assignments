

from multiprocessing.sharedctypes import Value


try:
    filename = input("Enter filename: ")

    infile = open(filename, "r")
    line = infile.readline()
    Value = int(line)
    print(line)
except ValueError:
    print("value error")
except IOError:
    print("No directory")