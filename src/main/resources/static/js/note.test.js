
import { mount } from '@vue/test-utils'
import note from './note.js';
global.axios = {
    get() { return Promise.resolve({ data: []}) },
    post() { return Promise.resolve('') }
}

test('shows greeting',  async () =>  {
    const wrapper = mount(note);
    expect(wrapper.text()).toContain('Hallo, ich hoffe du hattest einen schönen Tag!')
})
