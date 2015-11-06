# Getting the Current Date and Time
from datetime import datetime

now = datetime.now()
print now



# Extracting Information
from datetime import datetime

now = datetime.now()
print now
print now.year
print now.month
print now.day



# Hot Date
from datetime import datetime
now = datetime.now()

print '%s/%s/%s' % (now.month, now.day, now.year)



# Pretty Time
from datetime import datetime
now = datetime.now()

print '%s:%s:%s' % (now.hour, now.minute, now.second)



# Grand Finale
from datetime import datetime
now = datetime.now()

print '%s/%s/%s %s:%s:%s' % (now.month, now.day, now.year, now.hour, now.minute, now.second)