# -*- coding: utf-8 -*-
import smbus
import time
import sys
import urllib  # urlencode
import urllib2  # Request, urlopen

# print time.clock()

# sys.exit(1)

ADDRESS_SLAVE_PROMINI = 0x0a
OFFSET = 0
BYTE_LENGTH = 2

while(1):
	""" I2C COMMUNICATION """
	# Khoi tao doi tuong SMbus
	bus = smbus.SMBus(1)
	
	# Giao thuc duoc su dung la I2C
	# Luu du lieu lay duoc tu promini vao data_list
	data_sensor = bus.read_i2c_block_data(
	ADDRESS_SLAVE_PROMINI, OFFSET, BYTE_LENGTH)

	# Gui tra du lieu vua nhan duoc cho promini phuc vu
	# cho viec dubug (In ra man hinh Serial monitor cua promini)
	bus.write_byte(ADDRESS_SLAVE_PROMINI, data_sensor[0]) 
	bus.write_byte(ADDRESS_SLAVE_PROMINI, data_sensor[1])

	bus.close()

	""" gui du lieu tu raspberry cho server  """
	
	encode_data_sensor = {'temp': data_sensor[0],
			'humi': data_sensor[1]}
	POST_data = urllib.urlencode(encode_data_sensor)
	
	url_send_data = 'http://10.10.41.73:8080/test/data'

	request_send_data = urllib2.Request(url_send_data, POST_data)

	html_send_data = urllib2.urlopen(request_send_data)
	print html_send_data.read()

	""" lay du lieu tu server ve"""
	
	url_fade = 'http://10.10.41.73:8080/test/fade'

	html_fade = urllib2.urlopen(url_fade)
	print html_fade.read()
	
	# print html_file.read()
	
	# Tam dung 1s
	time.sleep(1)
