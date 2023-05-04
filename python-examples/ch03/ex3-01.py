from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from chromedriver_py import binary_path # this will get you the path variable
from selenium.webdriver.common.by import By

try:
    # service_object = Service(binary_path)
    # driver = webdriver.Chrome(service=service_object)

    # 下面语句执行成功的前提是，环境变量 chromedriver 版本要支持执行环境的 chrome 浏览器版本
    driver = webdriver.Chrome()

    driver.get("http://cn.bing.com/")
    description = driver.find_element(By.NAME, "description").get_attribute('content')
    print(description)
    assert ('Bing' in description) or ('必应' in description) 
except AssertionError as e:
    print('error!!!')
    raise e
finally:
    driver.quit()