import re

# Load the file contents into a string
with open('NVIDIA.txt', 'r') as file:
    file_contents = file.read()

# Apply the regex substitution
cleaned_contents = re.sub(r'\s{2,}', ' ', file_contents)

# Write the cleaned contents to a new file
with open('new.txt', 'w') as file:
    file.write(cleaned_contents)
